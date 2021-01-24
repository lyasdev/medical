package com.lyaslim.medical.patient.domain.ports.out;

import java.util.Optional;

public interface MyRepository<T, ID> {

	Optional<T> find(ID id);
	
	Iterable<T> findAll();
	
	<S extends T> S save(S entity);
	
	<S extends T> Iterable<S> saveAll(Iterable<S> entities);
	
}
