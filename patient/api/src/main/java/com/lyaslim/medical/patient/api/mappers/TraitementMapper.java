package com.lyaslim.medical.patient.api.mappers;

import com.lyaslim.medical.commons.api.mappers.CommonMapper;
import com.lyaslim.medical.patient.api.dtos.MedicamentRefDto;
import com.lyaslim.medical.patient.api.dtos.TraitementDtos;
import com.lyaslim.medical.patient.domain.model.MedicamentRef;
import com.lyaslim.medical.patient.domain.model.Traitement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface TraitementMapper extends CommonMapper<Traitement, TraitementDtos> {

    TraitementMapper INSTANCE = Mappers.getMapper(TraitementMapper.class);

    @Mapping(target = "typeTrtId", source = "typeTrt.id")
    @Mapping(target = "typeTrtLabel", source = "typeTrt.label")
    @Mapping(target = "medicamentsRef", source = "medicaments")
    TraitementDtos toDto(Traitement traitement);

    Set<MedicamentRefDto> toDto(Set<MedicamentRef> medicamentRef);

    default  MedicamentRefDto toDto(MedicamentRef medicamentRef){
        return MedicamentRefMapper.INSTANCE.toDto(medicamentRef);
    }
}
