package com.example.ex6.ex6.service;

import com.example.ex6.ex6.entity.Cliente;
import com.example.ex6.ex6.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void salvar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void  excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
}
