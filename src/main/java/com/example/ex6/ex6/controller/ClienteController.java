package com.example.ex6.ex6.controller;

import com.example.ex6.ex6.entity.Cliente;
import com.example.ex6.ex6.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public void save(@RequestBody Cliente cliente) {
        clienteService.salvar(cliente);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        clienteService.excluir(id);
    }

    @GetMapping
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @GetMapping("{id}")
    public Cliente buscarPorId(@PathVariable Long id){
        return clienteService.findById(id);
    }


}
