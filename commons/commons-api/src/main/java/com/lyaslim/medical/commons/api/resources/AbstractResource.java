package com.lyaslim.medical.commons.api.resources;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lyaslim.medical.commons.api.dtos.DtoToEntityMapper;
import com.lyaslim.medical.commons.api.mappers.CommonMapper;
import com.lyaslim.medical.commons.domain.ports.in.CommonsUseCases;

public class AbstractResource<E,ID,D extends DtoToEntityMapper<E>>  {
    private final CommonsUseCases<E, ID> service;

    private final CommonMapper<E, D> mapper;

    protected AbstractResource(CommonsUseCases<E, ID> service, CommonMapper<E, D> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<Collection<D>> getAll() {
      final Collection<E> result=new ArrayList<>();
      for(E entity : service.findAll()){
          result.add(entity);
      }
        return ResponseEntity.ok().body(result.stream().
                map(mapper::toDto).collect(toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable ID id) {
        return ResponseEntity.ok()
                .body(service.find(id).map(mapper::toDto).orElseThrow(IllegalArgumentException::new));
    }

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) {
        E insertedEntity = service.save(dto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(insertedEntity));
    }

    @PutMapping
    public ResponseEntity<D> update(@RequestBody D dto) {
        E entity = service.save(dto.toEntity());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mapper.toDto(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
