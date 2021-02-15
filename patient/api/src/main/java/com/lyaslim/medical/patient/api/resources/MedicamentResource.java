package com.lyaslim.medical.patient.api.resources;

import com.lyaslim.medical.commons.api.resources.AbstractResource;
import com.lyaslim.medical.patient.api.dtos.MedicamentDto;
import com.lyaslim.medical.patient.api.mappers.MedicamentMapper;
import com.lyaslim.medical.patient.domain.model.Medicament;
import com.lyaslim.medical.patient.domain.ports.in.MedicamentUseCases;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicaments")
public class MedicamentResource extends AbstractResource<Medicament, Long, MedicamentDto> {

    protected MedicamentResource(MedicamentUseCases service) {
        super(service, MedicamentMapper.INSTANCE);
    }

}
