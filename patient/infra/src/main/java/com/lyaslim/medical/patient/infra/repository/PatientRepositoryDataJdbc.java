package com.lyaslim.medical.patient.infra.repository;

import org.springframework.data.repository.NoRepositoryBean;

import com.lyaslim.medical.commons.infra.AbstractDataJdbcRepository;
import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;

@NoRepositoryBean
public class PatientRepositoryDataJdbc extends AbstractDataJdbcRepository<Patient, Long, PatientRepositoryLocal> implements PatientRepository {

    public PatientRepositoryDataJdbc(PatientRepositoryLocal delegate){
        super(delegate);
    }
}
