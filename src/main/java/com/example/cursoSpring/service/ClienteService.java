package com.example.cursoSpring.service;

import com.example.cursoSpring.model.Cliente;
import com.example.cursoSpring.repository.IClienteRepository;
import org.mariadb.jdbc.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Aquí es donde irá la lógica de negocio. Tiene un objeto de la interfaz que hereda de JPA
// repo.
@Service
public class ClienteService implements IClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {

        return clienteRepository.save(cliente);
    }


    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
