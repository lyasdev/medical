package com.lyaslim.medical.patient.api.dtos;

import com.lyaslim.medical.commons.api.dtos.DtoToEntityMapper;
import com.lyaslim.medical.patient.api.mappers.ConsultationMapper;
import com.lyaslim.medical.patient.domain.model.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Data
@ToString
public class TraitementDtos implements DtoToEntityMapper<Traitement> {
    private Long id;
    private String dateTrt;
    private Integer typeTrtId;
    private String typeTrtLabel;
    private Set<MedicamentDto> medicaments = Collections.emptySet();
    private Set<MedicamentRefDto> medicamentsRef = Collections.emptySet() ;

    @Override
    public Traitement toEntity() {
        var dateTraitement = !Objects.isNull(dateTrt) ? LocalDate.parse(dateTrt,
                DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
        var typeTraitement = Objects.isNull(typeTrtId) ? null : TypeTraitement.from(typeTrtId);
        return Traitement.of(id, dateTraitement, typeTraitement, medicaments.stream()
                .map(medicament -> new MedicamentRef(medicament.getId()))
                .collect(toSet()));
    }

}
