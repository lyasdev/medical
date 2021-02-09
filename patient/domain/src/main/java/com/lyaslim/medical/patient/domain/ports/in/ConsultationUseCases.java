package com.lyaslim.medical.patient.domain.ports.in;

import com.lyaslim.medical.commons.domain.ports.in.AbstractCommonsUseCases;
import com.lyaslim.medical.commons.domain.ports.in.CommonsUseCases;
import com.lyaslim.medical.commons.domain.ports.out.CommonRepository;
import com.lyaslim.medical.patient.domain.model.Consultation;
import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.out.IConsultationRepository;

public class ConsultationUseCases extends AbstractCommonsUseCases<Consultation, Long> implements IConsultationUseCases {
    private final IConsultationRepository repository;

    public ConsultationUseCases(IConsultationRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Iterable<Consultation> findByPatient(Long id) {
        return repository.findByPatient(id);
    }
}
