package com.example.ex6.ex6.controller;

import com.example.ex6.ex6.entity.Cliente;
import com.example.ex6.ex6.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> request = clienteService.findAll();
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        Cliente save = clienteService.save(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return clienteService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.update(id, cliente));
    }
}
