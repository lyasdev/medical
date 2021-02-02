package com.lyaslim.medical.app.conf.resources;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyaslim.medical.patient.api.dtos.PatientDto;
import com.lyaslim.medical.patient.domain.model.Sexe;

@Sql("/Patient.sql")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class PatientResourceITTest {

	@Autowired
	private MockMvc mockMvc;
	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void patientResourceTest() throws Exception {
		// all
		mockMvc.perform(get("/patient").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].firstName", is("BOURAHLA")))
				.andExpect(jsonPath("$[0].lastName", is("Slimane")))
				.andExpect(jsonPath("$[0].dateOfBirth", is("21/01/1985")))
				.andExpect(jsonPath("$[0].sexeId", is(Sexe.MALE.getId())))
				.andExpect(jsonPath("$[0].sexeLabel", is(Sexe.MALE.getLabel())))
				.andExpect(jsonPath("$[1].firstName", is("SAID AISSA")))
				.andExpect(jsonPath("$[1].lastName", is("Lyes")))
				.andExpect(jsonPath("$[1].dateOfBirth", is("10/01/1988")))
				.andExpect(jsonPath("$[1].sexeId", is(Sexe.MALE.getId())))
				.andExpect(jsonPath("$[1].sexeLabel", is(Sexe.MALE.getLabel())));

		// one
		mockMvc.perform(get("/patient/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.firstName", is("BOURAHLA"))).andExpect(jsonPath("$.lastName", is("Slimane")))
				.andExpect(jsonPath("$.sexeId", is(Sexe.MALE.getId())))
				.andExpect(jsonPath("$.sexeLabel", is(Sexe.MALE.getLabel())));

		// create
		PatientDto patientDto = new PatientDto();
		patientDto.setFirstName("test");
		patientDto.setLastName("test");
		patientDto.setDateOfBirth("21/01/1985");
		patientDto.setSexeId(2);
		mockMvc.perform(post("/patient").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(patientDto)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.firstName", is("test"))).andExpect(jsonPath("$.lastName", is("test")))
				.andExpect(jsonPath("$.sexeId", is(Sexe.FEMALE.getId())))
				.andExpect(jsonPath("$.sexeLabel", is(Sexe.FEMALE.getLabel())));

		// update
		patientDto.setId(3L);
		patientDto.setFirstName("test 2");
		patientDto.setLastName("test 2");
		patientDto.setDateOfBirth("21/02/1985");
		patientDto.setSexeId(1);
		mockMvc.perform(put("/patient").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(patientDto)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.firstName", is("test 2"))).andExpect(jsonPath("$.lastName", is("test 2")))
				.andExpect(jsonPath("$.dateOfBirth", is("21/02/1985")))
				.andExpect(jsonPath("$.sexeId", is(Sexe.MALE.getId())))
				.andExpect(jsonPath("$.sexeLabel", is(Sexe.MALE.getLabel())));

		// delete
		mockMvc.perform(delete("/patient/3").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());

		// all
		mockMvc.perform(get("/patient").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)));
		//Exception is not found
		mockMvc.perform(get("/patient/3").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.details[0]",is("Entity with id 3 not found ")));
		//Exception invalid entity
		patientDto = new PatientDto();
		patientDto.setFirstName(null);
		patientDto.setLastName("t");
		patientDto.setDateOfBirth(null);
		patientDto.setSexeId(null);
		mockMvc.perform(post("/patient").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(patientDto)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnprocessableEntity())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.details[0]",is("first name cannot be null")))
				.andExpect(jsonPath("$.details[1]",is("last name length must be > 2")))
				.andExpect(jsonPath("$.details[2]",is("date of birth cannot be null")))
				.andExpect(jsonPath("$.details[3]",is("sexe cannot be null")))
		;

	}
}