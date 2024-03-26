package com.reto.ClientePersona.services;

import com.reto.ClientePersona.models.Cuenta;
import com.reto.ClientePersona.models.Persona;
import com.reto.ClientePersona.models.dtos.CuentaDto;
import com.reto.ClientePersona.models.mappers.CuentaMapper;
import com.reto.ClientePersona.repositories.CuentaRepository;
import com.reto.ClientePersona.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private PersonaRepository personaRepository;

    public List<CuentaDto> getAllCuentasById(Long id) {
        Persona persona = personaRepository.findById(id).orElseThrow(()->new RuntimeException("Persona no encontrada"));
        return cuentaRepository.findByPersonaId(id).stream()
                .map(e ->{
                    CuentaDto cuentaDto = CuentaMapper.INSTANCE.cuentaToDto(e);
                    cuentaDto.setPersonaId(persona.getId());
                    cuentaDto.setNombrePersona(persona.getNombre());
                    return cuentaDto;
                })
                .collect(Collectors.toList());
    }

    public Optional<Cuenta> getCuentaById(Long id) {
        return cuentaRepository.findById(id);
    }

    public CuentaDto saveCuenta(CuentaDto cuentaDto) {
        Persona persona = personaRepository.findById(cuentaDto.getPersonaId()).orElseThrow(()->new RuntimeException("Persona no encontrada"));
        Cuenta cuenta = CuentaMapper.INSTANCE.dtoToCuenta(cuentaDto);
        cuenta.setPersona(persona);
        cuentaRepository.save(cuenta);
        cuentaDto.setId(cuenta.getId());
        cuentaDto.setNombrePersona(persona.getNombre());
        return cuentaDto;
    }
    public void updateEstado(Long id, Boolean estado) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(()->new RuntimeException("Cuenta no encontrada"));
        cuenta.setEstado(estado);
        cuentaRepository.save(cuenta);
    }

    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}
