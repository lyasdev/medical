package com.lyaslim.medical.patient.domain.ports.out;

import com.lyaslim.medical.commons.domain.ports.out.CommonRepository;
import com.lyaslim.medical.patient.domain.model.Consultation;

public interface ConsultationRepository extends CommonRepository<Consultation, Long> {
    Iterable<Consultation> findByPatient(Long id);
}
