package com.reto.ClientePersona.controllers;

import com.reto.ClientePersona.models.Persona;
import com.reto.ClientePersona.models.dtos.PersonaDto;
import com.reto.ClientePersona.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<PersonaDto>> getAllPersonas() {
        return ResponseEntity.ok(personaService.getAllPersonas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        return ResponseEntity.ok(personaService.getPersonaById(id));
    }

    @PostMapping
    public ResponseEntity<PersonaDto> createPersona(@RequestBody PersonaDto persona) {
        return ResponseEntity.ok(personaService.createPersona(persona));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return ResponseEntity.ok().build();
    }
}
