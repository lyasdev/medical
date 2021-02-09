package com.lyaslim.medical.patient.infra.repository;

import com.lyaslim.medical.patient.domain.model.Consultation;
import com.lyaslim.medical.patient.domain.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepositoryLocal extends CrudRepository<Consultation, Long> {

    Iterable<Consultation> findByPatientId(Long id);
}
