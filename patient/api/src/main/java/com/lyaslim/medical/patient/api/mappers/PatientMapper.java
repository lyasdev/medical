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
    
    @Mapping(target = "sexeId", source = "person.sexe.id")
    @Mapping(target = "sexeLabel", source = "person.sexe.label")
    @Mapping(target = "dateOfBirth", source = "person.birthDate",dateFormat = "dd/MM/yyyy")
    @Mapping(target = "firstName", source = "person.name.firstName")
    @Mapping(target = "middleName", source = "person.name.middleName")
    @Mapping(target = "lastName", source = "person.name.lastName")
    @Mapping(target = "identityCardNumber", source = "person.identityCardNumber")
    @Mapping(target = "bloodGroupId", source = "person.bloodGroup.id")
    PatientDto toDto(Patient patient);

}
