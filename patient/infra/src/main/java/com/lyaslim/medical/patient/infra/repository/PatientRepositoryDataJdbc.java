package com.lyaslim.medical.patient.infra.repository;

import java.util.Optional;

import com.lyaslim.medical.commons.infra.AbstractDataJdbcRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;

import lombok.RequiredArgsConstructor;

@NoRepositoryBean
public class PatientRepositoryDataJdbc extends AbstractDataJdbcRepository<Patient, Long> implements PatientRepository {

    public PatientRepositoryDataJdbc(PatientRepositoryLocal delegate){
        super(delegate);
    }
}
