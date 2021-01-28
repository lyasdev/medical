package com.lyaslim.medical.patient.api.resources;

import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.in.PatientUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientResource {

	private final PatientUseCases service;
	
	@GetMapping()
	public ResponseEntity<Iterable<Patient>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Patient> get(@PathVariable Long id) {
		return ResponseEntity.ok(service.find(id).orElseThrow(IllegalArgumentException::new));
	}
	
}
