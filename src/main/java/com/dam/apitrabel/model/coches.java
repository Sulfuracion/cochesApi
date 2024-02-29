package com.dam.apitrabel.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "coches")
public class coches {
    
    private String id;
    private String modelo;
    private String marca;
    private String color;
    private int potencia;

}
