package com.lyaslim.medical.patient.api.mappers;

import com.lyaslim.medical.patient.api.dtos.PatientDto;
import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.model.Sexe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    @Mapping(source = "sexe.id", target = "sexeId")
    PatientDto toDto(Patient patient);


}
