package com.lyaslim.medical.patient.api.dtos;

import com.lyaslim.medical.commons.api.dtos.DtoToEntityMapper;
import com.lyaslim.medical.patient.domain.model.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Data
@ToString
public class ConsultationDto implements DtoToEntityMapper<Consultation> {

    private Long id;
    private String date;
    private String histoireMaladie;
    private Long patientId;
    @Override
    public Consultation toEntity() {
        var dt=Objects.isNull(date) ? null: LocalDate.parse(date,
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Consultation.of(id,dt,histoireMaladie,patientId);
    }
}
