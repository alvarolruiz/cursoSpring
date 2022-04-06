package com.example.cursoSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
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
    @NotNull (message = "El apellido no puede ser nulo")
    @Size(max = 70,  message = "El apellido debe tener longitud mayor que 1 y menor que 70")
    private String apellidos;

    @Size(max = 150, message = "La dirección no debe superar 150 caracteres")
    private String direccion;

    @Range(min=100000000, max = 999999999, message = "Número de telefono no válido")
    private String telefono;

    @NotNull
    @NotBlank
    private String email;

    public Cliente(String nombre, String apellidos, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
}
