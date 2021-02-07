package com.lyaslim.medical.patient.domain.model;

import com.google.common.base.Preconditions;
import com.lyaslim.medical.commons.domain.exception.Checker;
import com.lyaslim.medical.commons.domain.exception.InvalidEntityException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import org.springframework.data.relational.core.mapping.Embedded;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * this is a value object representing Person, it is a final immutable class
 *
 * @author Slimane
 */
@Value(staticConstructor="of")
public final class Person {
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private final Name name;
    private final LocalDate birthDate;
    private final Sexe sexe;
    private final BloodGroup bloodGroup;
    private final String identityCardNumber;

    private Person(Name name, LocalDate birthDate,Sexe sexe, BloodGroup bloodGroup, String identityCardNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.sexe = sexe;
        this.bloodGroup = bloodGroup;
        this.identityCardNumber = identityCardNumber;
        checkValidity();
    }

    private void checkValidity() {
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
