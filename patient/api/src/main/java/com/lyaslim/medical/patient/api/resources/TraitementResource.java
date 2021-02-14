package com.lyaslim.medical.patient.api.resources;

import com.lyaslim.medical.commons.api.resources.AbstractResource;
import com.lyaslim.medical.patient.api.dtos.TraitementDtos;
import com.lyaslim.medical.patient.api.mappers.TraitementMapper;
import com.lyaslim.medical.patient.domain.model.Traitement;
import com.lyaslim.medical.patient.domain.ports.in.MedicamentUseCases;
import com.lyaslim.medical.patient.domain.ports.in.TraitementUseCases;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/traitements")
public class TraitementResource extends AbstractResource<Traitement, Long, TraitementDtos> {

    protected TraitementResource(TraitementUseCases service) {
        super(service, TraitementMapper.INSTANCE);

    }


}
