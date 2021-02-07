package com.lyaslim.medical.patient.domain.model;

import com.lyaslim.medical.commons.domain.exception.Checker;
import com.lyaslim.medical.commons.domain.exception.InvalidEntityException;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * this is a value object representing naming, it is a final immutable class
 *
 * @author Slimane
 */
@Value(staticConstructor = "of")
public final class Name {

    private final String firstName;
    private final String middleName;
    private final String lastName;

    private Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        checkValidity();
    }

    private void checkValidity() {
        List<String> errors = new ArrayList<>();
        Checker.check(errors, "first name cannot be null", Objects.isNull(firstName));
        Checker.check(errors, "first name length must be > 2", !Objects.isNull(firstName) && firstName.length() <= 2);
        Checker.check(errors, "last name cannot be null", Objects.isNull(lastName));
        Checker.check(errors, "last name length must be > 2", !Objects.isNull(lastName) && lastName.length() <= 2);
        Checker.throwException(errors);
    }
}
