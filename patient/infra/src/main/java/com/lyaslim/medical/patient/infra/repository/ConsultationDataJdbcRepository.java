package com.lyaslim.medical.patient.infra.repository;

import com.lyaslim.medical.commons.infra.AbstractDataJdbcRepository;
import com.lyaslim.medical.patient.domain.model.Consultation;
import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.out.ConsultationRepository;
import com.lyaslim.medical.patient.domain.ports.out.IConsultationRepository;
import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class ConsultationDataJdbcRepository extends AbstractDataJdbcRepository<Consultation, Long> implements IConsultationRepository {
    private ConsultationRepositoryLocal delegate;

    public ConsultationDataJdbcRepository(ConsultationRepositoryLocal delegate) {

        super(delegate);
        this.delegate = delegate;
    }

    @Override
    public Iterable<Consultation> findByPatient(Long id) {
        return delegate.findByPatientId(id);
    }
}
