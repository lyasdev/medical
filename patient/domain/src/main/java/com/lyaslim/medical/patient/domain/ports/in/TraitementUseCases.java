package com.lyaslim.medical.patient.domain.ports.in;

import com.lyaslim.medical.commons.domain.ports.in.AbstractCommonsUseCases;
import com.lyaslim.medical.commons.domain.ports.in.CommonsUseCases;
import com.lyaslim.medical.commons.domain.ports.out.CommonRepository;
import com.lyaslim.medical.patient.domain.model.Traitement;

public class TraitementUseCases extends AbstractCommonsUseCases<Traitement, Long> implements CommonsUseCases<Traitement, Long> {

    public TraitementUseCases(CommonRepository<Traitement, Long> repository) {
        super(repository);
    }

}
