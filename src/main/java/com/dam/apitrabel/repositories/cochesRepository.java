package com.dam.apitrabel.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dam.apitrabel.model.coches;
import java.util.Optional;



public interface cochesRepository extends MongoRepository<coches, String>{
    
    public abstract ArrayList<coches> findAll();
    public abstract ArrayList<coches> findByEscala(int escala);
    public abstract ArrayList<coches> findByOrigen(String origen);
    public abstract ArrayList<coches> findByOrigenAndDestino(String origen, String destino);
    public abstract ArrayList<coches> findByDestino(String destino);
    public abstract coches save(coches viaje);
    public abstract void deleteByNombre(String nombre);
    public abstract Optional<coches> findById(String id);
}
