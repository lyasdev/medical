package com.lyaslim.medical.patient.api.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.lyaslim.medical.commons.api.dtos.DtoToEntityMapper;
import com.lyaslim.medical.patient.domain.model.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PatientDto implements DtoToEntityMapper<Patient> {

	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private Integer sexeId;
	private String sexeLabel;
	private String identityCardNumber;
	private Integer bloodGroupId;

	@Override
	public Patient toEntity() {
		var dob = Objects.isNull(dateOfBirth) ? null
				: LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		var sexe = Objects.isNull(sexeId) ? null : Sexe.from(sexeId);
		var blood = Objects.isNull(bloodGroupId) ? null : BloodGroup.from(bloodGroupId);
		Name name = new Name(firstName, middleName, lastName);
		Person person = new Person(name, dob, sexe, blood, identityCardNumber);
		return Patient.of(id, person);
	}
}
