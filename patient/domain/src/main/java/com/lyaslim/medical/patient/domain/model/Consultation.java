package com.lyaslim.medical.patient.domain.model;

import com.lyaslim.medical.commons.domain.exception.Checker;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.LocalDate;
import java.util.*;

@Value(staticConstructor = "of")
public class Consultation {
    @Id
    Long id;
    LocalDate date;
    String histoireMaladie;
    Long patientId;
    @MappedCollection(keyColumn = "CONSULTATION_ID", idColumn = "CONSULTATION_ID")
    private Set<Traitement> traitements;

    private Consultation(Long id, LocalDate date, String histoireMaladie, Long patientId, Set<Traitement> traitements) {
        this.id = id;
        this.date = date;
        this.histoireMaladie = histoireMaladie;
        this.patientId = patientId;
        this.traitements = traitements == null ? new HashSet<>() : new HashSet<>(traitements);
        checkValidity();
    }

    public void addTraitement(Traitement traitement) {
        traitements.add(traitement);
    }

    public void checkValidity() {
        List<String> errors = new ArrayList<>();
        Checker.check(errors, "date can not be null", Objects.isNull(date));
        Checker.check(errors, "patient can not be null", Objects.isNull(patientId));
        Checker.throwException(errors);
    }
}
