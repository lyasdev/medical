package com.lyaslim.medical.app.conf.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyaslim.medical.patient.api.dtos.PatientDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.lyaslim.medical.patient.domain.model.Sexe;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Sql("/Patient.sql")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class PatientResourceITTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper=new ObjectMapper();

    @Test
    void shouldReturnAllPatientTest() throws Exception {
        mockMvc.perform(get("/patient")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath( "$",hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", is("BOURAHLA")))
                .andExpect(jsonPath("$[0].lastName", is("Slimane")))
                .andExpect(jsonPath("$[0].sexeId", is(Sexe.MALE.getId())))
                .andExpect(jsonPath("$[0].sexeLabel", is(Sexe.MALE.getLabel())))
                .andExpect(jsonPath("$[1].firstName", is("SAID AISSA")))
                .andExpect(jsonPath("$[1].lastName", is("Lyes")))
                .andExpect(jsonPath("$[1].sexeId", is(Sexe.MALE.getId())))
                .andExpect(jsonPath("$[1].sexeLabel", is(Sexe.MALE.getLabel())));
    }
    @Test
    void shouldReturnOnePatientTest() throws Exception {
        mockMvc.perform(get("/patient/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName", is("BOURAHLA")))
                .andExpect(jsonPath("$.lastName", is("Slimane")))
                .andExpect(jsonPath("$.sexeId", is(Sexe.MALE.getId())))
                .andExpect(jsonPath("$.sexeLabel", is(Sexe.MALE.getLabel())));
    }
    @Test
    void shouldCreatePatientTest() throws Exception {
        PatientDto patientDto=new PatientDto();
        patientDto.setFirstName("test");
        patientDto.setLastName("test");
        patientDto.setDateOfBirth("21/01/1985");
        patientDto.setSexeId(2);
        mockMvc.perform(post("/patient")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(patientDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName", is("test")))
                .andExpect(jsonPath("$.lastName", is("test")))
                .andExpect(jsonPath("$.sexeId", is(Sexe.FEMALE.getId())))
                .andExpect(jsonPath("$.sexeLabel", is(Sexe.FEMALE.getLabel())));
    }
}