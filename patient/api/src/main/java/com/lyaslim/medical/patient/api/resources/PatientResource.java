package com.lyaslim.medical.patient.api.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lyaslim.medical.commons.api.resources.AbstractResource;
import com.lyaslim.medical.patient.api.dtos.PatientDto;
import com.lyaslim.medical.patient.api.mappers.PatientMapper;
import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.in.PatientUseCases;

@RestController
@RequestMapping("/patients")
public class PatientResource extends AbstractResource<Patient, Long, PatientUseCases, PatientDto> {

    protected PatientResource(PatientUseCases service) {
        super(service, PatientMapper.INSTANCE);
    }

}
