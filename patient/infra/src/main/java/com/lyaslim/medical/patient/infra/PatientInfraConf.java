package com.lyaslim.medical.patient.infra;

import com.lyaslim.medical.patient.domain.ports.out.*;
import com.lyaslim.medical.patient.infra.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

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

    @Autowired
    TraitementRepositoryLocal traitementRepositoryLocal;

    @Autowired
    MedicamentRepositoryLocal medicamentRepositoryLocal;

    @Bean
    PatientRepository createPatientRepository() {

        return new PatientRepositoryDataJdbc(patientRepositoryLocal);
    }

    @Bean
    ConsultationRepository createConsultationRepository() {
        return new ConsultationDataJdbcRepository(consultationRepositoryLocal);
    }

    @Bean
    TraitementRepository createTraitementRepository() {

        return new TraitementRepositoryDataJdbc(traitementRepositoryLocal);
    }

    @Bean
    MedicamentRepository createMedicamentRepository() {

        return new MedicamentRepositoryDataJdbc(medicamentRepositoryLocal);
    }
}
