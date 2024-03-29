package com.lyaslim.medical.patient.api.resources;

import com.lyaslim.medical.commons.api.resources.AbstractResource;
import com.lyaslim.medical.patient.api.dtos.ConsultationDto;
import com.lyaslim.medical.patient.api.mappers.ConsultationMapper;
import com.lyaslim.medical.patient.api.mappers.PatientMapper;
import com.lyaslim.medical.patient.domain.model.Consultation;
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
public class ConsultationResource extends AbstractResource<Consultation, Long, IConsultationUseCases, ConsultationDto> {
    
    private final PatientUseCases patientService;
    private final PatientMapper patientMapper;
    
    protected ConsultationResource(IConsultationUseCases service, PatientUseCases patientService) {
        super(service, ConsultationMapper.INSTANCE);
        this.patientService = patientService;
        this.patientMapper=PatientMapper.INSTANCE;
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Collection<ConsultationDto>> getAllByPatient(@PathVariable Long id) {
        final Collection<Consultation> result = new ArrayList<>();
        for (Consultation entity : super.service.findByPatient(id)) {
            result.add(entity);
        }
        return ResponseEntity.ok().body(result.stream().
                map(super.mapper::toDto).collect(toList()));
    }

    @GetMapping("/{id}/with-patient")
    public ResponseEntity<ConsultationDto> getConsultationWithPatient(@PathVariable Long id) {
        ConsultationDto consultationDto = service.find(id).map(super.mapper::toDto).get();
        consultationDto.setPatient(
                this.patientMapper.toDto(
                        patientService.find(consultationDto.getPatientId()).get())
               );
        return ResponseEntity.ok()
                .body(consultationDto);
    }
}
