package com.lyaslim.medical.app.conf.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyaslim.medical.patient.api.dtos.MedicamentDto;
import com.lyaslim.medical.patient.api.dtos.TraitementDtos;
import com.lyaslim.medical.patient.domain.model.TypeTraitement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@Sql("/Drop_Tables.sql")
@Sql("/Patient.sql")
@Sql("/Consultation.sql")
@Sql("/Medicamen.sql")
@Sql("/Traitement.sql")
@Sql("/Medicament_Traitement.sql")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class TraitementResourceITTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void traitementResourceTest() throws Exception {
        // all
        ResultActions result= mockMvc.perform(get("/traitements").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].medicaments",  hasSize(1)))
                .andExpect(jsonPath("$[0].medicamentsRef",  hasSize(1)));

        // one
        mockMvc.perform(get("/traitements/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dateTrt", is("2021-01-21")))
                .andExpect(jsonPath("$.typeTrtId", is(TypeTraitement.ORDONNANCE.getId())))
                .andExpect(jsonPath("$.typeTrtLabel", is(TypeTraitement.ORDONNANCE.getLabel())))
                .andExpect(jsonPath("$.medicaments", hasSize(1)));
        // create with medicament
        TraitementDtos traitementDtos = new TraitementDtos();
        traitementDtos.setDateTrt("21/11/2021");
        traitementDtos.setTypeTrtId(1);
        traitementDtos.setTypeTrtLabel("Ordonnance");
        MedicamentDto medicamentDto =new MedicamentDto();
        medicamentDto.setId(2L);
        medicamentDto.setDci("PARACETAMOL");
        medicamentDto.setNom_commercial("EFFERALGAN");
        medicamentDto.setIndications("AVANT LES REPAS");
        medicamentDto.setContre_indication("NE PAS UTILISER DANS LE CAS D''UNE ALLERGIE");
        traitementDtos.setMedicaments(Set.of(medicamentDto));

        mockMvc.perform(post("/traitements").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(traitementDtos)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dateTrt", is("2021-11-21")))
                .andExpect(jsonPath("$.typeTrtId", is(TypeTraitement.ORDONNANCE.getId())))
                .andExpect(jsonPath("$.typeTrtLabel", is(TypeTraitement.ORDONNANCE.getLabel())))
                .andExpect(jsonPath("$.medicaments", hasSize(1)));
        // create without medicament
        TraitementDtos traitementDtos2 = new TraitementDtos();
        traitementDtos2.setDateTrt("30/01/2021");
        traitementDtos2.setTypeTrtId(2);
        traitementDtos2.setTypeTrtLabel("Autres");

        mockMvc.perform(post("/traitements").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(traitementDtos2)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dateTrt", is("2021-01-30")))
                .andExpect(jsonPath("$.typeTrtId", is(TypeTraitement.AUTRES.getId())))
                .andExpect(jsonPath("$.typeTrtLabel", is(TypeTraitement.AUTRES.getLabel())))
                .andExpect(jsonPath("$.medicaments", hasSize(0)));
    }
}