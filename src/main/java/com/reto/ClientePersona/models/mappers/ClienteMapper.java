package com.reto.ClientePersona.models.mappers;

import com.reto.ClientePersona.models.Cliente;
import com.reto.ClientePersona.models.dtos.ClienteDto;
import com.reto.ClientePersona.models.dtos.ClientePersonaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente dtoToCliente(ClienteDto clienteDto);
    Cliente CliPerdtoToCliente(ClientePersonaDto clientePersonaDto);
    ClienteDto clienteToDto(Cliente cliente);
}
