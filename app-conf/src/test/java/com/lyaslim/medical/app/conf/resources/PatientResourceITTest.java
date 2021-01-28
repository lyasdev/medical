package com.lyaslim.medical.app.conf.resources;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Sql("/Patient.sql")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class PatientResourceITTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAllPatientTest() throws Exception {
        mockMvc.perform(get("/patient")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath( "$",hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", is("BOURAHLA")))
                .andExpect(jsonPath("$[1].firstName", is("SAID AISSA")));
    }
    @Test
    void shouldReturnOnePatientTest() throws Exception {
        mockMvc.perform(get("/patient/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName", is("BOURAHLA")));
    }
}