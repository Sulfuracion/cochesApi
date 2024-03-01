package com.dam.apitrabel.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dam.apitrabel.model.coches;
import java.util.Optional;



public interface cochesRepository extends MongoRepository<coches, String>{//Esta interfaz define un repositorio
    
 // Métodos de consulta personalizados que permiten buscar coches por diferentes criterios.

    // Encuentra todos los coches en la colección 'coches'.
    public abstract ArrayList<coches> findAll();

    // Encuentra coches por su potencia.
    public abstract ArrayList<coches> findByPotencia(int potencia);

    // Encuentra coches por su marca.
    public abstract ArrayList<coches> findByMarca(String marca);

    // Encuentra coches por su marca y modelo.
    public abstract ArrayList<coches> findByMarcaModelo(String marca, String modelo);

    // Encuentra coches por su modelo.
    public abstract ArrayList<coches> findByModelo(String modelo);

    // Métodos para operaciones CRUD adicionales.

    // Guarda un nuevo coche en la base de datos.
    public abstract coches save(coches viaje);

    // Elimina coches por su modelo.
    public abstract void deleteByModelo(String modelo);

    // Busca un coche por su identificador único.
    public abstract Optional<coches> findById(String id);
}
