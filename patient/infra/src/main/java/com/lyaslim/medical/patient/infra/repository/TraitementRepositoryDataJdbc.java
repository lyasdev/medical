package com.lyaslim.medical.patient.infra.repository;

import org.springframework.data.repository.NoRepositoryBean;

import com.lyaslim.medical.commons.infra.AbstractDataJdbcRepository;
import com.lyaslim.medical.patient.domain.model.Traitement;
import com.lyaslim.medical.patient.domain.ports.out.TraitementRepository;

@NoRepositoryBean
public class TraitementRepositoryDataJdbc extends AbstractDataJdbcRepository<Traitement, Long, TraitementRepositoryLocal> implements TraitementRepository {

    public TraitementRepositoryDataJdbc(TraitementRepositoryLocal delegate){
        super(delegate);
    }
}
