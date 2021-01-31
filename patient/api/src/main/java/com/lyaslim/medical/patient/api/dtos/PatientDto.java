package com.lyaslim.medical.patient.api.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        return Patient.of(id,firstName,lastName,LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy")), Sexe.from(sexeId));
    }
}
