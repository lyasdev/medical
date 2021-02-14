package com.lyaslim.medical.patient.infra.repository;

import com.lyaslim.medical.commons.infra.AbstractDataJdbcRepository;
import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.model.Traitement;
import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;
import com.lyaslim.medical.patient.domain.ports.out.TraitementRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class TraitementRepositoryDataJdbc extends AbstractDataJdbcRepository<Traitement, Long> implements TraitementRepository {

    public TraitementRepositoryDataJdbc(TraitementRepositoryLocal delegate){
        super(delegate);
    }
}
