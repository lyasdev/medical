package com.lyaslim.medical.patient.domain;

import com.lyaslim.medical.patient.domain.ports.in.ConsultationUseCases;
import com.lyaslim.medical.patient.domain.ports.out.ConsultationRepository;
import com.lyaslim.medical.patient.domain.ports.out.IConsultationRepository;
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

    @Autowired
    private IConsultationRepository consultationRepository;

    @Bean
    PatientUseCases createPatientUseCases() {
    	return new PatientUseCases(patientRepository);
    }

    @Bean
    ConsultationUseCases createConsultationUseCases() {
        return new ConsultationUseCases(consultationRepository);
    }
}
