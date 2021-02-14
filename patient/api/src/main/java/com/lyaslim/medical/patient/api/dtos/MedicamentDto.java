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
    private String nom_commercial;
    private String description;
    private String indications;
    private String contre_indication;
    @Override
    public Medicament toEntity() {
        return Medicament.of(id,dci,nom_commercial,description,indications,contre_indication);
    }
}
