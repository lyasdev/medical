package com.lyaslim.medical.patient.domain.ports.in;

import java.util.Optional;

import com.lyaslim.medical.patient.domain.ports.out.MyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractCommonsUseCases<T, ID> implements CommonsUseCases<T, ID> {

	private final MyRepository<T, ID> repository;
	
	public Optional<T> find(ID id) {
		return repository.find(id);
	}

	public Iterable<T> findAll() {
		return repository.findAll();
	}

	public T save(T entity) {
		return repository.save(entity);
	}

	public Iterable<T> saveAll(Iterable<T> entities) {
		return repository.saveAll(entities);
	}

}
