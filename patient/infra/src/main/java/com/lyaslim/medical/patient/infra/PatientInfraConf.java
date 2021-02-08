package com.lyaslim.medical.patient.infra;

import com.lyaslim.medical.patient.domain.ports.out.ConsultationRepository;
import com.lyaslim.medical.patient.domain.ports.out.IConsultationRepository;
import com.lyaslim.medical.patient.infra.repository.ConsultationDataJdbcRepository;
import com.lyaslim.medical.patient.infra.repository.ConsultationRepositoryLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;
import com.lyaslim.medical.patient.infra.repository.PatientRepositoryDataJdbc;
import com.lyaslim.medical.patient.infra.repository.PatientRepositoryLocal;

/**
 * Hello world!
 */
@Configuration
@EnableJdbcRepositories
@ComponentScan(basePackages = "com.lyaslim.medical.patient.infra.repository")
@Import(DataJdbcConf.class)
public class PatientInfraConf {
    @Autowired
    PatientRepositoryLocal patientRepositoryLocal;

    @Autowired
    ConsultationRepositoryLocal consultationRepositoryLocal;

    @Bean
    PatientRepository createPatientRepository() {

        return new PatientRepositoryDataJdbc(patientRepositoryLocal);
    }

    @Bean
    IConsultationRepository createConsultationRepository() {
        return new ConsultationDataJdbcRepository(consultationRepositoryLocal);
    }
}
