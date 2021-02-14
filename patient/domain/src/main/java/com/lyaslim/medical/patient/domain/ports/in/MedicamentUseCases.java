package com.lyaslim.medical.patient.domain.ports.in;

import com.lyaslim.medical.commons.domain.ports.in.AbstractCommonsUseCases;
import com.lyaslim.medical.commons.domain.ports.in.CommonsUseCases;
import com.lyaslim.medical.commons.domain.ports.out.CommonRepository;
import com.lyaslim.medical.patient.domain.model.Medicament;
import com.lyaslim.medical.patient.domain.model.Traitement;

public class MedicamentUseCases extends AbstractCommonsUseCases<Medicament, Long> implements CommonsUseCases<Medicament, Long> {

    public MedicamentUseCases(CommonRepository<Medicament, Long> repository) {
        super(repository);
    }
}
