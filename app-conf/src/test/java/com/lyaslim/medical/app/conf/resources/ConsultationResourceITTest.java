package com.lyaslim.medical.app.conf.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyaslim.medical.patient.api.dtos.ConsultationDto;
import com.lyaslim.medical.patient.api.dtos.PatientDto;
import com.lyaslim.medical.patient.domain.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@Sql("/Drop_Tables.sql")
@Sql("/Patient.sql")
@Sql("/Consultation.sql")
@Sql("/Traitement.sql")
@Sql("/Medicamen.sql")
@Sql("/Medicament_Traitement.sql")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ConsultationResourceITTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void consultationResourceTest() throws Exception {
        // all
       ResultActions result= mockMvc.perform(get("/consultations").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
        // one
        mockMvc.perform(get("/consultations/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.date", is("1985-01-21")))
                .andExpect(jsonPath("$.histoireMaladie", is("Atteint d'une insuffisance renale terminal a lage de 25 ans")))
                .andExpect(jsonPath("$.patientId", is(1)));
        // create
        ConsultationDto consultationDto = new ConsultationDto();
        consultationDto.setDate("21/10/2021");
        consultationDto.setHistoireMaladie("Ce patient est atteint d'un diabete");
        consultationDto.setPatientId(1L);
        mockMvc.perform(post("/consultations").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(consultationDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.date", is("2021-10-21")))
                .andExpect(jsonPath("$.histoireMaladie", is("Ce patient est atteint d'un diabete")))
                .andExpect(jsonPath("$.patientId", is(1)));
        //Update
        consultationDto.setId(4L);
        consultationDto.setDate("10/10/2021");
        consultationDto.setHistoireMaladie("test");
        consultationDto.setPatientId(2L);
        mockMvc.perform(put("/consultations").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(consultationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.date", is("2021-10-10")))
                .andExpect(jsonPath("$.histoireMaladie", is("test")))
                .andExpect(jsonPath("$.patientId", is(2)));
        // delete
        mockMvc.perform(delete("/consultations/4").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        //all
        mockMvc.perform(get("/consultations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
        //Exception is not found
        consultationDto.setDate(null);
        consultationDto.setPatientId(null);
        mockMvc.perform(post("/consultations").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(consultationDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.details[0]", is("date can not be null")))
                .andExpect(jsonPath("$.details[1]", is("patient can not be null")));
        //Consultation with patient details
        mockMvc.perform(get("/consultations/1/with-patient").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.patient.dateOfBirth", is("21/01/1985")))
                .andExpect(jsonPath("$.patient.id", is(1)))
                .andExpect(jsonPath("$.patient.firstName", is("BOURAHLA")))
                .andExpect(jsonPath("$.patient.middleName", is("Slim")))
                .andExpect(jsonPath("$.patient.lastName", is("Slimane")))
                .andExpect(jsonPath("$.patient.sexeId", is(Sexe.MALE.getId())))
                .andExpect(jsonPath("$.patient.sexeLabel", is(Sexe.MALE.getLabel())))
                .andExpect(jsonPath("$.patient.identityCardNumber", is("0019826354")));
    }
}