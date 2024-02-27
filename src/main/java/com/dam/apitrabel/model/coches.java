package com.dam.apitrabel.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "trips")
public class coches {
    
    private String id;
    private String nombre;
    private String origen;
    private String destino;
    private int escala;
    private int duracion;
    private double precio;
}
