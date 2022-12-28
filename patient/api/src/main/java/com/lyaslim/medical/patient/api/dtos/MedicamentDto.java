package com.lyaslim.medical.patient.api.dtos;

import com.lyaslim.medical.commons.api.dtos.DtoToEntityMapper;
import com.lyaslim.medical.patient.domain.model.Medicament;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MedicamentDto implements DtoToEntityMapper<Medicament> {
    private Long id;
    private String dci;
    private String nomCommercial;
    private String description;
    private String indications;
    private String contreIndication;
    @Override
    public Medicament toEntity() {
        return Medicament.of(id, dci, nomCommercial, description, indications, contreIndication);
    }
}
