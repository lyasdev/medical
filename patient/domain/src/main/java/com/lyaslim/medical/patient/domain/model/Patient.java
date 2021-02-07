package com.lyaslim.medical.patient.domain.model;

import com.lyaslim.medical.commons.domain.exception.Checker;
import com.lyaslim.medical.commons.domain.exception.InvalidEntityException;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Value
public class Patient {

    @Id
    Long id;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    Person person;

    private Patient(Long id, Person person) {
        this.id = id;
        this.person = person;
        this.checkValidity();
    }

    public static Patient of(Long id, Person person) {
        return new Patient(id, person);
    }

    public void checkValidity() {
        List<String> errors = new ArrayList<>();
        Checker.check(errors, "person cannot be null", Objects.isNull(person));
        Checker.throwException(errors);
    }

}
