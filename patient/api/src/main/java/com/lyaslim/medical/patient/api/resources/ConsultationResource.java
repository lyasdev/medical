package com.lyaslim.medical.patient.api.resources;

import com.lyaslim.medical.commons.api.resources.AbstractResource;
import com.lyaslim.medical.patient.api.dtos.ConsultationDto;
import com.lyaslim.medical.patient.api.dtos.PatientDto;
import com.lyaslim.medical.patient.api.mappers.ConsultationMapper;
import com.lyaslim.medical.patient.api.mappers.PatientMapper;
import com.lyaslim.medical.patient.domain.model.Consultation;
import com.lyaslim.medical.patient.domain.model.Patient;
import com.lyaslim.medical.patient.domain.ports.in.ConsultationUseCases;
import com.lyaslim.medical.patient.domain.ports.in.IConsultationUseCases;
import com.lyaslim.medical.patient.domain.ports.in.PatientUseCases;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/consultations")
public class ConsultationResource extends AbstractResource<Consultation, Long, ConsultationDto> {
    private final IConsultationUseCases service;

    protected ConsultationResource(IConsultationUseCases service) {
        super(service, ConsultationMapper.INSTANCE);
        this.service = service;
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Collection<ConsultationDto>> getAllByPatient(@PathVariable Long id) {
        final Collection<Consultation> result = new ArrayList<>();
        for (Consultation entity : service.findByPatient(id)) {
            result.add(entity);
        }
        return ResponseEntity.ok().body(result.stream().
                map(getMapper()::toDto).collect(toList()));
    }
}
