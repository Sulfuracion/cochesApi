package com.dam.apitrabel.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data//genera métodos getter y setter, además de los métodos toString(), equals(), y hashCode()
@Document(collection = "coches")//mapear documentos almacenados
public class coches {
    
    private String id;
    private String modelo;
    private String marca;
    private String color;
    private int potencia;

}
