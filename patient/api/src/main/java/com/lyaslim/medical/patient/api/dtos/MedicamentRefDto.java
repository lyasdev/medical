package com.lyaslim.medical.patient.api.dtos;

import com.lyaslim.medical.commons.api.dtos.DtoToEntityMapper;
import com.lyaslim.medical.patient.domain.model.MedicamentRef;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MedicamentRefDto implements DtoToEntityMapper<MedicamentRef> {
    private Long id;
    @Override
    public MedicamentRef toEntity() {
        return new MedicamentRef(id);
    }
}
