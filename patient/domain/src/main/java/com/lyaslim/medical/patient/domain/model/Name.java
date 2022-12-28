package com.lyaslim.medical.patient.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.lyaslim.medical.commons.domain.exception.Checker;

public record Name(String firstName, String middleName, String lastName) {

    public Name {
    	List<String> errors = new ArrayList<>();
        Checker.check(errors, "first name cannot be null", Objects.isNull(firstName));
        Checker.check(errors, "first name length must be > 2", !Objects.isNull(firstName) && firstName.length() <= 2);
        Checker.check(errors, "last name cannot be null", Objects.isNull(lastName));
        Checker.check(errors, "last name length must be > 2", !Objects.isNull(lastName) && lastName.length() <= 2);
        Checker.throwException(errors);
    }
}
