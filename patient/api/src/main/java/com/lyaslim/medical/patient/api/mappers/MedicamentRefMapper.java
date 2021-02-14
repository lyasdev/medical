package com.lyaslim.medical.patient.api.mappers;

import com.lyaslim.medical.commons.api.mappers.CommonMapper;
import com.lyaslim.medical.patient.api.dtos.MedicamentDto;
import com.lyaslim.medical.patient.api.dtos.MedicamentRefDto;
import com.lyaslim.medical.patient.domain.model.MedicamentRef;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface MedicamentRefMapper extends CommonMapper<MedicamentRef, MedicamentRefDto> {

    MedicamentRefMapper INSTANCE = Mappers.getMapper(MedicamentRefMapper.class);
    Set<MedicamentDto> toDto(Set<MedicamentRef> entities) ;
    @Mapping(target = "id", source = "medicamentId")
    MedicamentRefDto toDto(MedicamentRef medicamentRef);

}
