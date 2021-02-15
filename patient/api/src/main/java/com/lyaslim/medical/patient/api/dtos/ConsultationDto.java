package com.lyaslim.medical.patient.api.dtos;

import com.lyaslim.medical.commons.api.dtos.DtoToEntityMapper;
import com.lyaslim.medical.patient.domain.model.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Data
@ToString
public class ConsultationDto implements DtoToEntityMapper<Consultation> {

    private Long id;
    private String date;
    private String histoireMaladie;
    private Long patientId;
    private PatientDto patient;
    private Set<TraitementDtos> traitements = Collections.emptySet();

    @Override
    public Consultation toEntity() {
        var dt = Objects.isNull(date) ? null : LocalDate.parse(date,
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Consultation.of(id, dt, histoireMaladie, patientId, traitements.stream()
                .map(TraitementDtos::toEntity).collect(toSet()));
    }
}
