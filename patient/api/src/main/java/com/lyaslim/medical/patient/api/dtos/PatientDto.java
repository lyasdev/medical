package com.lyaslim.medical.patient.api.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.lyaslim.medical.commons.api.dtos.DtoToEntityMapper;
import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.model.Sexe;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PatientDto implements DtoToEntityMapper<Patient> {

    private Long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private Integer sexeId;
    private String sexeLabel;

    @Override
    public Patient toEntity() {
        var dob  = Objects.isNull(dateOfBirth) ? null: LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var sexe = Objects.isNull(sexeId) ? null : Sexe.from(sexeId);
        return Patient.of(id,firstName,lastName,dob,
                sexe);
    }
}
