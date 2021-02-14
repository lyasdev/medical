package com.lyaslim.medical.patient.api.mappers;

import com.lyaslim.medical.commons.api.mappers.CommonMapper;
import com.lyaslim.medical.patient.api.dtos.ConsultationDto;
import com.lyaslim.medical.patient.api.dtos.TraitementDtos;
import com.lyaslim.medical.patient.domain.model.Consultation;
import com.lyaslim.medical.patient.domain.model.Traitement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface ConsultationMapper extends CommonMapper<Consultation, ConsultationDto> {

    ConsultationMapper INSTANCE = Mappers.getMapper(ConsultationMapper.class);

    Set<TraitementDtos> toDto(Set<Traitement> entities) ;

    ConsultationDto toDto(Consultation consultation);

    default TraitementDtos toDto (Traitement traitement){
        return TraitementMapper.INSTANCE.toDto(traitement);
    }

}
