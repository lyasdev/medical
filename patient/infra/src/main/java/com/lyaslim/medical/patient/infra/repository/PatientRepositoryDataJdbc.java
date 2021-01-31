package com.lyaslim.medical.patient.infra.repository;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;

import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;

import lombok.RequiredArgsConstructor;

@NoRepositoryBean
@RequiredArgsConstructor
public class PatientRepositoryDataJdbc implements PatientRepository {

	private final PatientRepositoryLocal delegate;
	
	public <S extends Patient> S save(S entity) {
		return this.delegate.save(entity);
	}

	public <S extends Patient> Iterable<S> saveAll(Iterable<S> entities) {
		return this.delegate.saveAll(entities);
	}

	public Optional<Patient> find(Long id) {
		return this.delegate.findById(id);
	}

	public Iterable<Patient> findAll() {
		return this.delegate.findAll();
	}

	public void deleteById(Long id){
		this.delegate.deleteById(id);
	}
}
