package com.lyaslim.medical.patient.api.mappers;

import com.lyaslim.medical.commons.api.mappers.CommonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lyaslim.medical.patient.api.dtos.PatientDto;
import com.lyaslim.medical.patient.domain.model.Patient;

@Mapper
public interface PatientMapper extends CommonMapper<Patient,PatientDto> {
	
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    
    @Mapping(target = "sexeId", source = "sexe.id")
    @Mapping(target = "sexeLabel", source = "sexe.label")
    @Mapping(target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    PatientDto toDto(Patient patient);

}
