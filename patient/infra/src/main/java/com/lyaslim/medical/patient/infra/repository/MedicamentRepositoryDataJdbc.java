package com.lyaslim.medical.patient.infra.repository;

import org.springframework.data.repository.NoRepositoryBean;

import com.lyaslim.medical.commons.infra.AbstractDataJdbcRepository;
import com.lyaslim.medical.patient.domain.model.Medicament;
import com.lyaslim.medical.patient.domain.ports.out.MedicamentRepository;

@NoRepositoryBean
public class MedicamentRepositoryDataJdbc extends AbstractDataJdbcRepository<Medicament, Long, MedicamentRepositoryLocal> implements MedicamentRepository {

    public MedicamentRepositoryDataJdbc(MedicamentRepositoryLocal delegate){
        super(delegate);
    }
}
