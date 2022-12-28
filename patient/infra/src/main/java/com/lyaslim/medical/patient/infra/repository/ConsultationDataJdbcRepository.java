package com.lyaslim.medical.patient.infra.repository;

import org.springframework.data.repository.NoRepositoryBean;

import com.lyaslim.medical.commons.infra.AbstractDataJdbcRepository;
import com.lyaslim.medical.patient.domain.model.Consultation;
import com.lyaslim.medical.patient.domain.ports.out.ConsultationRepository;

@NoRepositoryBean
public class ConsultationDataJdbcRepository extends AbstractDataJdbcRepository<Consultation, Long,ConsultationRepositoryLocal> implements ConsultationRepository {
   
    public ConsultationDataJdbcRepository(ConsultationRepositoryLocal delegate) {
        super(delegate);
    }

    @Override
    public Iterable<Consultation> findByPatient(Long id) {
        return super.delegate.findByPatientId(id);
    }
}
