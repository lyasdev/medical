package com.lyaslim.medical.patient.api.mappers;

import com.lyaslim.medical.commons.api.mappers.CommonMapper;
import com.lyaslim.medical.patient.api.dtos.MedicamentDto;
import com.lyaslim.medical.patient.domain.model.Medicament;
import com.lyaslim.medical.patient.domain.model.MedicamentRef;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface MedicamentMapper extends CommonMapper<Medicament, MedicamentDto> {

    MedicamentMapper INSTANCE = Mappers.getMapper(MedicamentMapper.class);

    MedicamentDto toDto(Medicament medicament);

}
