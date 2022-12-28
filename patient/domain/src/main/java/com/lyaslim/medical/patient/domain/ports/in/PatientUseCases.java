package com.lyaslim.medical.patient.domain.ports.in;

import com.lyaslim.medical.commons.domain.ports.in.AbstractCommonsUseCases;
import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;

public class PatientUseCases extends AbstractCommonsUseCases<Patient, Long, PatientRepository> implements IPatientUseCases {
	
	public PatientUseCases(PatientRepository repository) {
		super(repository);
	}	

}
