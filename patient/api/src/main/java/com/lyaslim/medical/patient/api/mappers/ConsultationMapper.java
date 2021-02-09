package com.lyaslim.medical.patient.api.mappers;

import com.lyaslim.medical.commons.api.mappers.CommonMapper;
import com.lyaslim.medical.patient.api.dtos.ConsultationDto;
import com.lyaslim.medical.patient.api.dtos.PatientDto;
import com.lyaslim.medical.patient.domain.model.Consultation;
import com.lyaslim.medical.patient.domain.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsultationMapper extends CommonMapper<Consultation, ConsultationDto> {

    ConsultationMapper INSTANCE = Mappers.getMapper(ConsultationMapper.class);


    ConsultationDto toDto(Consultation consultation);

}
