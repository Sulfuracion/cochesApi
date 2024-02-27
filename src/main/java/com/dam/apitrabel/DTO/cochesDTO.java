package com.dam.apitrabel.DTO;

import lombok.Data;

@Data
public class cochesDTO {
    
    private String nombre;
    private String origen;
    private String destino;
    private int escala;
    private int duracion;
    private double precio;
}
