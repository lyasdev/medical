package com.lyaslim.medical.patient.domain.ports.out;

import com.lyaslim.medical.commons.domain.ports.out.CommonRepository;
import com.lyaslim.medical.patient.domain.model.Patient;

public interface PatientRepository extends CommonRepository<Patient, Long> {
}
