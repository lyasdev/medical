package com.lyaslim.medical.patient.infra.repository;

import com.lyaslim.medical.commons.infra.AbstractDataJdbcRepository;
import com.lyaslim.medical.patient.domain.model.Medicament;
import com.lyaslim.medical.patient.domain.model.Traitement;
import com.lyaslim.medical.patient.domain.ports.out.MedicamentRepository;
import com.lyaslim.medical.patient.domain.ports.out.TraitementRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class MedicamentRepositoryDataJdbc extends AbstractDataJdbcRepository<Medicament, Long> implements MedicamentRepository {

    public MedicamentRepositoryDataJdbc(MedicamentRepositoryLocal delegate){
        super(delegate);
    }
}
