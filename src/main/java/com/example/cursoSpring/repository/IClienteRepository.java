package com.example.cursoSpring.repository;

import com.example.cursoSpring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
