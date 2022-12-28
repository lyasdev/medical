package com.lyaslim.medical.patient.infra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lyaslim.medical.patient.domain.model.Consultation;

@Repository
public interface ConsultationRepositoryLocal extends CrudRepository<Consultation, Long> {

    Iterable<Consultation> findByPatientId(Long id);
}
