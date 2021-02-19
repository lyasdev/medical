package com.lyaslim.medical.patient.domain.ports.in;

import com.lyaslim.medical.commons.domain.ports.in.CommonsUseCases;
import com.lyaslim.medical.patient.domain.model.Consultation;
import com.lyaslim.medical.patient.domain.model.Patient;

public interface IConsultationUseCases extends CommonsUseCases<Consultation, Long> {
     Iterable<Consultation> findByPatient(Long id);
}