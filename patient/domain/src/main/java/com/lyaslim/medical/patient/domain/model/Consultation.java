package com.lyaslim.medical.patient.domain.model;

import com.lyaslim.medical.commons.domain.exception.Checker;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Value(staticConstructor = "of")
public class Consultation {
    @Id
    Long id;
    LocalDate date;
    String histoireMaladie;
    Long patientId;

    private Consultation(Long id, LocalDate date, String histoireMaladie,  Long patientId) {
        this.id = id;
        this.date = date;
        this.histoireMaladie = histoireMaladie;
        this.patientId = patientId;
        checkValidity();
    }

    public void checkValidity() {
        List<String> errors = new ArrayList<>();
        Checker.check(errors, "date can not be null", Objects.isNull(date));
        Checker.check(errors, "patient can not be null", Objects.isNull(patientId));
        Checker.throwException(errors);
    }
}
