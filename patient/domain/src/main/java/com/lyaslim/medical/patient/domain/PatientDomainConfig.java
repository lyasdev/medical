package com.lyaslim.medical.patient.domain;

import com.lyaslim.medical.patient.domain.ports.in.ConsultationUseCases;
import com.lyaslim.medical.patient.domain.ports.in.MedicamentUseCases;
import com.lyaslim.medical.patient.domain.ports.in.PatientUseCases;
import com.lyaslim.medical.patient.domain.ports.in.TraitementUseCases;
import com.lyaslim.medical.patient.domain.ports.out.ConsultationRepository;
import com.lyaslim.medical.patient.domain.ports.out.MedicamentRepository;
import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;
import com.lyaslim.medical.patient.domain.ports.out.TraitementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientDomainConfig {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private TraitementRepository traitementRepository;

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Bean
    PatientUseCases createPatientUseCases() {
        return new PatientUseCases(patientRepository);
    }

    @Bean
    ConsultationUseCases createConsultationUseCases() {
        return new ConsultationUseCases(consultationRepository);
    }

    @Bean
    TraitementUseCases createTraitementUseCases() {
        return new TraitementUseCases(traitementRepository);
    }

    @Bean
    MedicamentUseCases createMedicamentUseCases() {
        return new MedicamentUseCases(medicamentRepository);
    }
}
