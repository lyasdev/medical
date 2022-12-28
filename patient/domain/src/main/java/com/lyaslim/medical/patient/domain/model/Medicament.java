package com.lyaslim.medical.patient.domain.model;

import com.lyaslim.medical.commons.domain.exception.Checker;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Value(staticConstructor = "of")
public class Medicament {
    @Id
    Long id;
    String dci;
    String nom_commercial;
    String description;
    String indications;
    String contre_indication;

    private Medicament(Long id, String dci, String nom_commercial, String description, String indications, String contre_indication){
        this.id = id;
        this.dci = dci;
        this.nom_commercial = nom_commercial;
        this.description = description;
        this.indications = indications;
        this.contre_indication = contre_indication;
        checkValidity();
    }
    
    public void checkValidity() {
        List<String> errors = new ArrayList<>();
        Checker.check(errors, "dci cannot be null", Objects.isNull(dci));
        Checker.check(errors, "nom_commercial cannot be null", Objects.isNull(nom_commercial));
        Checker.check(errors, "description cannot be null", Objects.isNull(description));
        Checker.check(errors, "indications cannot be null", Objects.isNull(indications));
        Checker.check(errors, "contre_indication cannot be null", Objects.isNull(contre_indication));
        Checker.throwException(errors);
    }
}
