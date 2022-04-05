package com.example.cursoSpring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table (name =  "clientes")
public @Data
class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, length = 20)
    private Long idCliente;
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank
    @Size (min = 1, max = 70, message = "El nombre debe tener longitud mayor que 1 y menor que 70")
    private String nombre;
    @NotBlank
    @NotNull
    @Size(max = 70,  message = "El apellido debe tener longitud mayor que 1 y menor que 70")
    private String apellidos;
    @Size(max = 150, message = "La dirección no debe superar 150 caracteres")
    private String direccion;

    private String telefono;
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message = "El email debe ser valido")
    private String email;
}
