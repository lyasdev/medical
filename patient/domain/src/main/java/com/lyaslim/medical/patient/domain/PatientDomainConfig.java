package com.lyaslim.medical.patient.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lyaslim.medical.patient.domain.ports.in.PatientUseCases;
import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;

/**
 * Hello world!
 *
 */
@Configuration
public class PatientDomainConfig 
{
    @Autowired
    private PatientRepository patientRepository;
    
    @Bean
    PatientUseCases createPatientUseCases() {
    	return new PatientUseCases(patientRepository);
    }
}
