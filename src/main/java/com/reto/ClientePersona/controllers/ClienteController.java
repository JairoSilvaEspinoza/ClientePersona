package com.reto.ClientePersona.controllers;


import com.reto.ClientePersona.models.Cliente;
import com.reto.ClientePersona.models.dtos.ClienteDto;
import com.reto.ClientePersona.models.dtos.ClientePersonaDto;
import com.reto.ClientePersona.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    @GetMapping("/{id}")
        public ResponseEntity<ClienteDto> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteDto cliente) {
        return ResponseEntity.ok(clienteService.saveCliente(cliente));
    }
    @PostMapping("/createComplete")
    public ResponseEntity<ClientePersonaDto> createClientePersona(@RequestBody ClientePersonaDto cliente) {
        return ResponseEntity.ok(clienteService.saveClientePersona(cliente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.ok().build();
    }
}
