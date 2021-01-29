package com.lyaslim.medical.patient.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lyaslim.medical.patient.api.dtos.PatientDto;
import com.lyaslim.medical.patient.domain.model.Patient;

@Mapper
public interface PatientMapper {
	
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    
    @Mapping(target = "sexeId", source = "sexe.id")
    @Mapping(target = "sexeLabel", source = "sexe.label")
    PatientDto toDto(Patient patient);

}
