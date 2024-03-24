package com.reto.ClientePersona.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reto.ClientePersona.models.dtos.PersonaDto;
import com.reto.ClientePersona.utils.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PersonaControllerTest {


    @Autowired
    private MockMvc mockMvc;


    private PersonaDto personaDto;

    @BeforeEach
    void setUp() {
        this.personaDto = new PersonaDto();
        personaDto.setNombre("MARI");
        personaDto.setGenero("F");
        personaDto.setEdad(0);
        personaDto.setIdentificacion(Util.generateRandomId(8));
        personaDto.setDireccion("av canada");
        personaDto.setTelefono("7565455444");
    }

    @Test
    void getAllPersonas() throws Exception {
        mockMvc.perform(get("/personas"))
                .andExpect(status().isOk());
    }

    @Test
    void getPersonaById() throws Exception {
        mockMvc.perform(get("/personas/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void createPersona() throws Exception {
        MvcResult result = mockMvc.perform(post("/personas")
                            .content(asJsonString(personaDto))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk())
                            .andReturn();

        String response = result.getResponse().getContentAsString();
        PersonaDto createdPersona = new ObjectMapper().readValue(response, PersonaDto.class);

        //delete persona
        mockMvc.perform(delete("/personas/{id}", createdPersona.getId()))
                .andExpect(status().isOk());

    }

   /* @Test
    void deletePersona() throws Exception {
        mockMvc.perform(delete("/personas/{id}", id))
                .andExpect(status().isOk());
    }*/

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}