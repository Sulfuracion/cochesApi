package com.dam.apitrabel.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dam.apitrabel.model.coches;
import java.util.Optional;



public interface cochesRepository extends MongoRepository<coches, String>{
    
    public abstract ArrayList<coches> findAll();
    public abstract ArrayList<coches> findByPotencia(int potencia);
    public abstract ArrayList<coches> findByMarca(String Marca);
    public abstract ArrayList<coches> findByMarcaModelo(String Marca, String modelo);
    public abstract ArrayList<coches> findByModelo(String modelo);

    public abstract coches save(coches viaje);
    public abstract void deleteByModelo(String modelo);
    public abstract Optional<coches> findById(String id);
}
