package com.lyaslim.medical.patient.domain.ports.in;

import com.lyaslim.medical.commons.domain.ports.in.AbstractCommonsUseCases;
import com.lyaslim.medical.patient.domain.model.Consultation;
import com.lyaslim.medical.patient.domain.ports.out.ConsultationRepository;

public class ConsultationUseCases extends AbstractCommonsUseCases<Consultation, Long, ConsultationRepository> implements IConsultationUseCases {

    public ConsultationUseCases(ConsultationRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Consultation> findByPatient(Long id) {
        return super.repository.findByPatient(id);
    }
}
