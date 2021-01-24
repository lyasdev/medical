package com.lyaslim.medical.patient.domain.ports.in;

import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.out.MyRepository;

public class PatientUseCases extends AbstractCommonsUseCases<Patient, Long> implements CommonsUseCases<Patient, Long> {	
	
	public PatientUseCases(MyRepository<Patient, Long> repository) {
		super(repository);
	}	

}
