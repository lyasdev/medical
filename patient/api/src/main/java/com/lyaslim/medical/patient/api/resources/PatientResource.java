package com.lyaslim.medical.patient.api.resources;

import java.util.ArrayList;
import java.util.Collection;

import com.lyaslim.medical.commons.api.mappers.CommonMapper;
import com.lyaslim.medical.commons.api.resources.AbstractResource;
import com.lyaslim.medical.commons.domain.ports.in.CommonsUseCases;
import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.out.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/patients")
public class PatientResource extends AbstractResource<Patient, Long, PatientDto> {

    protected PatientResource(PatientUseCases service) {
        super(service,PatientMapper.INSTANCE);
    }

}
