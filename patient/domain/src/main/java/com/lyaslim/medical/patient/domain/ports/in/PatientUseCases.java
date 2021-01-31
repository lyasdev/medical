package com.lyaslim.medical.patient.domain.ports.in;

import com.lyaslim.medical.commons.domain.ports.in.AbstractCommonsUseCases;
import com.lyaslim.medical.commons.domain.ports.in.CommonsUseCases;
import com.lyaslim.medical.commons.domain.ports.out.CommonRepository;
import com.lyaslim.medical.patient.domain.model.Patient;

public class PatientUseCases extends AbstractCommonsUseCases<Patient, Long> implements CommonsUseCases<Patient, Long> {
	
	public PatientUseCases(CommonRepository<Patient, Long> repository) {
		super(repository);
	}	

}
