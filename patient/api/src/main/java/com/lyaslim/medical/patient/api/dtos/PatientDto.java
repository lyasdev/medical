package com.lyaslim.medical.patient.api.dtos;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PatientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer sexeId;
    private String sexeLabel;

}
