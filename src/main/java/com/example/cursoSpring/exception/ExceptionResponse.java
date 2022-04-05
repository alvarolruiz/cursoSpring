package com.example.cursoSpring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@AllArgsConstructor
public @Data class ExceptionResponse extends RuntimeException{
    private Date timestamp;
    private String mensaje;
    private String detalles;
}
