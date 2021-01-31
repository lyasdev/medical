package com.lyaslim.medical.commons.domain.ports.in;

import java.util.Optional;

public interface CommonsUseCases<T, ID> {

	Optional<T> find(ID id);
	
	Iterable<T> findAll();
	
	T save(T entity);
	
	Iterable<T> saveAll(Iterable<T> entities);

	void delete(ID id);
	
}
