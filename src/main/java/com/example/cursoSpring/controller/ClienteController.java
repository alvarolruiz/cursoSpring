package com.example.cursoSpring.controller;

import com.example.cursoSpring.exception.ExceptionResponse;
import com.example.cursoSpring.model.Cliente;
import com.example.cursoSpring.service.ClienteService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> one(@PathVariable Long id)  {
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->new ResponseEntity<>(new Cliente(), HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private ResponseEntity<Cliente> create (@Valid @RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.CREATED);
    }

    @SneakyThrows
    @PutMapping("/{id}")
    private ResponseEntity<Cliente> update (@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
        return clienteService.findById(id)
                .map(c -> {
                    c.setNombre(cliente.getNombre());
                    c.setApellidos(cliente.getApellidos());
                    c.setDireccion(cliente.getDireccion());
                    c.setTelefono(cliente.getTelefono());
                    c.setEmail(cliente.getEmail());
                    return ResponseEntity.ok(clienteService.update(c));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Cliente> delete (@PathVariable Long id){
        return clienteService.findById(id)
                .map(c -> {
                    clienteService.delete(id);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
