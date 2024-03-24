package com.reto.ClientePersona.models.mappers;

import com.reto.ClientePersona.models.Persona;
import com.reto.ClientePersona.models.dtos.ClientePersonaDto;
import com.reto.ClientePersona.models.dtos.PersonaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    Persona dtoToPersona(PersonaDto personaDto);
    Persona CliPerdtoToPersona(ClientePersonaDto clientePersonaDto);
    ClientePersonaDto PersonaToCliPerdto(Persona clientePersonaDto);
    PersonaDto PersonaToDto(Persona persona);

}
