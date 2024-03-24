package com.reto.ClientePersona.services;

import com.reto.ClientePersona.models.Persona;
import com.reto.ClientePersona.models.dtos.PersonaDto;
import com.reto.ClientePersona.models.mappers.PersonaMapper;
import com.reto.ClientePersona.repositories.PersonaRepository;
import com.reto.ClientePersona.utils.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class PersonaServiceTest {

    @InjectMocks
    PersonaService personaService;

    @Mock
    PersonaRepository personaRepository;

    private Persona persona;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        persona = new Persona();
        persona.setId(1L);
        persona.setNombre("MARI");
        persona.setGenero("F");
        persona.setEdad(30);
        persona.setIdentificacion(Util.generateRandomId(8));
        persona.setDireccion("av canada");
        persona.setTelefono("7565455444");
    }

    @Test
    void getAllPersonas() {

        when(personaRepository.findAll()).thenReturn(Arrays.asList(persona));

        List<PersonaDto> result = personaService.getAllPersonas();

        verify(personaRepository, times(1)).findAll();
        assertEquals(1, result.size());
    }

    @Test
    void getPersonaById() {

        when(personaRepository.findById(1L)).thenReturn(Optional.of(persona));

        Persona result = personaService.getPersonaById(1L);

        verify(personaRepository, times(1)).findById(1L);
        assertEquals(persona, result);
    }

    @Test
    void createPersona() {
        PersonaDto personaDto = PersonaMapper.INSTANCE.PersonaToDto(persona);
        when(personaRepository.save(persona)).thenReturn(persona);
        PersonaDto result = personaService.createPersona(personaDto);
        assertEquals(personaDto, result);
    }

    @Test
    void deletePersona() {
        doNothing().when(personaRepository).deleteById(1L);
        personaService.deletePersona(1L);
        verify(personaRepository, times(1)).deleteById(1L);
    }
}