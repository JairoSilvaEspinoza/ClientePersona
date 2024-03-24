package com.reto.ClientePersona.services;

import com.reto.ClientePersona.models.Persona;
import com.reto.ClientePersona.models.dtos.PersonaDto;
import com.reto.ClientePersona.models.mappers.ClienteMapper;
import com.reto.ClientePersona.models.mappers.PersonaMapper;
import com.reto.ClientePersona.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<PersonaDto> getAllPersonas() {
        return StreamSupport.stream(personaRepository.findAll().spliterator(), false)
                .map(PersonaMapper.INSTANCE::PersonaToDto)
                .collect(Collectors.toList());
    }

    public Persona getPersonaById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public PersonaDto createPersona(PersonaDto personaDto) {
        Persona persona = PersonaMapper.INSTANCE.dtoToPersona(personaDto);
        personaRepository.save(persona);
        personaDto.setId(persona.getId());
        return personaDto;
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}