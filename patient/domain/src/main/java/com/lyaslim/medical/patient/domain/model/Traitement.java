package com.lyaslim.medical.patient.domain.model;

import com.lyaslim.medical.commons.domain.exception.Checker;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.LocalDate;
import java.util.*;

@Value(staticConstructor = "of")
public class Traitement {
    @Id
    Long id;
    LocalDate dateTrt;
    TypeTraitement typeTrt;
    @MappedCollection(idColumn = "TRAITEMENT_ID")
    Set<MedicamentRef> medicaments;


    private Traitement(Long id, LocalDate dateTrt, TypeTraitement typeTrt, Set<MedicamentRef> medicaments) {
        this.id = id;
        this.dateTrt = dateTrt;
        this.typeTrt = typeTrt;
        this.medicaments = medicaments == null ?
                new HashSet<>() : new HashSet<>(medicaments);
        checkValidity();
    }

    public void addMedicament(Medicament medicament) {
        medicaments.add(new MedicamentRef(medicament.getId()));
    }


    public void checkValidity() {
        List<String> errors = new ArrayList<>();
        Checker.check(errors, "date can not be null", Objects.isNull(dateTrt));
        Checker.check(errors, "typeTrt can not be null", Objects.isNull(typeTrt));
        Checker.throwException(errors);
    }
}
