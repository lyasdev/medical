package com.lyaslim.medical.commons.infra;

import com.lyaslim.medical.commons.domain.ports.out.CommonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;
@RequiredArgsConstructor
public class AbstractDataJdbcRepository<T, ID> implements CommonRepository<T, ID> {

    private final CrudRepository<T, ID> delegate;

    public <S extends T> S save(S entity) {
        return this.delegate.save(entity);
    }

    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        return this.delegate.saveAll(entities);
    }

    public Optional<T> find(ID id) {
        return this.delegate.findById(id);
    }

    public Iterable<T> findAll() {
        return this.delegate.findAll();
    }

    public void deleteById(ID id){
        this.delegate.deleteById(id);
    }
}
