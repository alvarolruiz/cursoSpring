package com.example.cursoSpring.service;

import com.example.cursoSpring.model.Cliente;
import org.mariadb.jdbc.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente create (Cliente cliente);
    Cliente update (Cliente cliente);
    void delete(Long id);
}
