package com.lyaslim.medical.patient.api.dtos;

import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.model.Sexe;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PatientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer sexeId;

}
