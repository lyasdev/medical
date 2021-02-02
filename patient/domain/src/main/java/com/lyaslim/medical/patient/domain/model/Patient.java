package com.lyaslim.medical.patient.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.lyaslim.medical.commons.domain.exception.InvalidEntityException;
import org.springframework.data.annotation.Id;

import com.google.common.base.Preconditions;

import lombok.Value;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Embedded;

@Value
public class Patient {

    @Id
    Long id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    Sexe sexe;

    private Patient(Long id,
                    String firstName,
                    String lastName,
                    LocalDate dateOfBirth,
                    Sexe sexe) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sexe = sexe;
        this.checkValidity();
    }

    public static Patient of(Long id,
                             String firstName,
                             String lastName,
                             LocalDate dateOfBirth,
                             Sexe sexe) {
        return new Patient(id, firstName, lastName, dateOfBirth, sexe);
    }

    public void checkValidity() {
        List<String> errors = new ArrayList<>();
        if (Objects.isNull(firstName)) {
            errors.add("first name cannot be null");
        }
        else if (firstName.length()<=2)
        {
            errors.add("first name length must be > 2");
        }
        if (Objects.isNull(lastName)) {
            errors.add("last name cannot be null");
        }
        else if (lastName.length()<=2)
        {
            errors.add("last name length must be > 2");
        }
        if (Objects.isNull(dateOfBirth)) {
            errors.add("date of birth cannot be null");
        }
        if (Objects.isNull(sexe)) {
            errors.add("sexe cannot be null");
        }
        if(errors.size()>0) {
            String errorMessage = errors.stream().collect(Collectors.joining(","));
            throw new InvalidEntityException(errorMessage);
        }
    }

}
