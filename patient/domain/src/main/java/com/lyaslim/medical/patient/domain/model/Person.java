package com.lyaslim.medical.patient.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.relational.core.mapping.Embedded;

import com.lyaslim.medical.commons.domain.exception.Checker;

public record Person(@Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY) Name name, LocalDate birthDate, Sexe sexe, BloodGroup bloodGroup, String identityCardNumber) {
   
    public Person {
    	List<String> errors = new ArrayList<>();
        Checker.check(errors, "name cannot be null", Objects.isNull(name));
        Checker.check(errors, "birthdate cannot be null", Objects.isNull(birthDate));
        Checker.check(errors, "birthdate cannot be less than 1 year ago", !Objects.isNull(birthDate) && !birthDate.isBefore(LocalDate.now().minusYears(1)));
        Checker.check(errors, "sexe cannot be null", Objects.isNull(sexe));
        Checker.check(errors, "bloodgroup cannot be null", Objects.isNull(bloodGroup));
        Checker.check(errors, "identity card number cannot be null", Objects.isNull(identityCardNumber));
        Checker.throwException(errors);
    }

}
