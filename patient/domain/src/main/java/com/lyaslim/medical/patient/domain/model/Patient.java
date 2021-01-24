package com.lyaslim.medical.patient.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.google.common.base.Preconditions;

import lombok.Value;

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
		Objects.requireNonNull(firstName, "first name cannot be null");
		Preconditions.checkArgument(firstName.length() > 2, "first name length must be > 2");
		Objects.requireNonNull(lastName, "last name cannot be null");
		Preconditions.checkArgument(lastName.length() > 2, "last name length must be > 2");
		Objects.requireNonNull(dateOfBirth, "date of birth cannot be null");
		Objects.requireNonNull(sexe, "sexe cannot be null");
	}

}
