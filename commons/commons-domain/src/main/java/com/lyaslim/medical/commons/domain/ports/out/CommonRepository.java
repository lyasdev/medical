package com.lyaslim.medical.commons.domain.ports.out;

import java.util.Optional;

public interface CommonRepository<T, ID> {

	Optional<T> find(ID id);
	
	Iterable<T> findAll();
	
	<S extends T> S save(S entity);
	
	<S extends T> Iterable<S> saveAll(Iterable<S> entities);

	void deleteById(ID id);
}
