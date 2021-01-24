package com.lyaslim.medical.patient.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;
import com.lyaslim.medical.patient.infra.repository.PatientRepositoryDataJdbc;
import com.lyaslim.medical.patient.infra.repository.PatientRepositoryLocal;

/**
 * Hello world!
 *
 */
@Configuration
@EnableJdbcRepositories
@ComponentScan(basePackages = "com.lyaslim.medical.patient.infra.repository")
public class PatientInfraConf 
{
	@Autowired
	PatientRepositoryLocal delegate;
	
    @Bean
    PatientRepository createPatientRepository() {
    	return new PatientRepositoryDataJdbc(delegate);
    }
}
