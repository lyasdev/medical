package com.lyaslim.medical.patient.api.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lyaslim.medical.commons.api.resources.AbstractResource;
import com.lyaslim.medical.patient.api.dtos.TraitementDtos;
import com.lyaslim.medical.patient.api.mappers.TraitementMapper;
import com.lyaslim.medical.patient.domain.model.Traitement;
import com.lyaslim.medical.patient.domain.ports.in.TraitementUseCases;

@RestController
@RequestMapping("/traitements")
public class TraitementResource extends AbstractResource<Traitement, Long, TraitementUseCases, TraitementDtos> {

	protected TraitementResource(TraitementUseCases service) {
		super(service, TraitementMapper.INSTANCE);
	}

}
