package com.lyaslim.medical.patient.domain.ports.in;

import com.lyaslim.medical.commons.domain.ports.in.AbstractCommonsUseCases;
import com.lyaslim.medical.patient.domain.model.Medicament;
import com.lyaslim.medical.patient.domain.ports.out.MedicamentRepository;

public class MedicamentUseCases extends AbstractCommonsUseCases<Medicament, Long, MedicamentRepository> implements IMedicamentUseCases {

    public MedicamentUseCases(MedicamentRepository repository) {
        super(repository);
    }
}
