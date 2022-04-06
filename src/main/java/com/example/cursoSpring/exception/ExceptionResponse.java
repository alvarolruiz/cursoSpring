package com.example.cursoSpring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@AllArgsConstructor
public @Data class ExceptionResponse extends RuntimeException{
    private Date timestamp;
    private String mensaje;
    private String detalles;
    private Map<String,String> erroresValidacion;

    public ExceptionResponse(Date timestamp, String mensaje, String detalles){
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }
}
