package com.example.ex6.ex6.service;

import com.example.ex6.ex6.entity.Cliente;
import com.example.ex6.ex6.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> buscar(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente update(Long id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }
}
