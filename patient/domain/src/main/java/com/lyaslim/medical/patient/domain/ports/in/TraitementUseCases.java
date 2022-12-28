package com.lyaslim.medical.patient.domain.ports.in;

import com.lyaslim.medical.commons.domain.ports.in.AbstractCommonsUseCases;
import com.lyaslim.medical.patient.domain.model.Traitement;
import com.lyaslim.medical.patient.domain.ports.out.TraitementRepository;

public class TraitementUseCases extends AbstractCommonsUseCases<Traitement, Long, TraitementRepository> implements ITraitementUseCases {

    public TraitementUseCases(TraitementRepository repository) {
        super(repository);
    }

}
