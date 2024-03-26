package com.reto.ClientePersona.services;

import com.reto.ClientePersona.models.Cliente;
import com.reto.ClientePersona.models.Persona;
import com.reto.ClientePersona.models.dtos.ClienteDto;
import com.reto.ClientePersona.models.dtos.ClientePersonaDto;
import com.reto.ClientePersona.models.mappers.ClienteMapper;
import com.reto.ClientePersona.models.mappers.PersonaMapper;
import com.reto.ClientePersona.repositories.ClienteRepository;
import com.reto.ClientePersona.repositories.PersonaRepository;
import com.reto.ClientePersona.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClienteService {

    @Autowired
    private  ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaRepository;
    @Transactional
    public ClientePersonaDto saveClientePersona(ClientePersonaDto clientePersonaDto) {

        Persona persona = PersonaMapper.INSTANCE.CliPerdtoToPersona(clientePersonaDto);
        Cliente cliente = ClienteMapper.INSTANCE.CliPerdtoToCliente(clientePersonaDto);
        personaRepository.save(persona);
        cliente.setPersona(persona);
        cliente.setContrasena(Util.encodePassword(cliente.getContrasena()));
        clienteRepository.save(cliente);
        clientePersonaDto.setClienteId(cliente.getId());
        clientePersonaDto.setPersonaId(persona.getId());
        return clientePersonaDto;
    }
    public Cliente saveCliente(ClienteDto clienteDto) {
        Persona persona = personaRepository.findById(clienteDto.getPersonaId()).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        Cliente cliente = ClienteMapper.INSTANCE.dtoToCliente(clienteDto);
        cliente.setContrasena(Util.encodePassword(cliente.getContrasena()));
        cliente.setPersona(persona);
        return clienteRepository.save(cliente);
    }

    public ClienteDto getClienteById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.map(ClienteMapper.INSTANCE::clienteToDto).orElseThrow(() -> new RuntimeException("cliente no encontrada"));
    }

    public List<ClienteDto> getAllClientes() {
        return StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
                .map(ClienteMapper.INSTANCE::clienteToDto)
                .collect(Collectors.toList());
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}