package com.lyaslim.medical.patient.api.resources;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lyaslim.medical.patient.api.dtos.PatientDto;
import com.lyaslim.medical.patient.api.mappers.PatientMapper;
import com.lyaslim.medical.patient.domain.ports.in.PatientUseCases;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientResource {

	private final PatientUseCases service;
	
	@GetMapping()
	public ResponseEntity<Collection<PatientDto>> getAll() {
		Collection<PatientDto> result = new ArrayList<>();
		service.findAll().forEach(e -> result.add(PatientMapper.INSTANCE.toDto(e)));
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PatientDto> get(@PathVariable Long id) {
		return ResponseEntity.ok(service.find(id).map(PatientMapper.INSTANCE::toDto).orElseThrow(IllegalArgumentException::new));
	}
	
}
