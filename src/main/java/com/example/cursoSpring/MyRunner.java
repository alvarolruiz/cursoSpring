package com.example.cursoSpring;


import com.example.cursoSpring.model.Cliente;
import com.example.cursoSpring.repository.IClienteRepository;
import com.example.cursoSpring.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Aqui puedo ejecutar los comandos que quiera.
@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private ClienteService clienteService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Saving clients");
        clienteService.create(new Cliente("John", "Doe", "Calle calle", "777888666", "johnDoe@gmail.com"));
        clienteService.create(new Cliente("Mike", "Doe", "Calle casa", "776688666", "mikeDoe@gmail.com"));
    }
}
