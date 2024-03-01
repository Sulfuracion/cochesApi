package com.dam.apitrabel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.apitrabel.DTO.cochesDTO;
import com.dam.apitrabel.model.coches;
import com.dam.apitrabel.repositories.cochesRepository;

@Service
public class CochesService {//ontiene la lógica relacionada con los coches
    
       // Inyecta automáticamente una instancia de cochesRepository en esta clase,
    // lo que permite que esta clase interactúe con la base de datos MongoDB.
    @Autowired
    private cochesRepository tripRepository;

    // Método para obtener todos los coches.
    public List<coches> getAllCoches(){
        return tripRepository.findAll();
    }

    // Método para obtener coches por potencia.
    public List<coches> getTripsByPotencia(int potencia){
        return tripRepository.findByPotencia(potencia);
    }

    // Método para obtener coches por marca.
    public List<coches> getCochesByMarca(String marca){
        return tripRepository.findByMarca(marca);
    }

    // Método para obtener coches por marca y modelo.
    public List<coches> getCochesByMarcaModelo(String modelo, String marca){
        return tripRepository.findByMarcaModelo(modelo, marca);
    }

    // Método para obtener coches por modelo.
    public List<coches> getCochesByModelo(String modelo){
        return tripRepository.findByModelo(modelo);
    }

    // Método para añadir un nuevo coche.
    public void postTrips(cochesDTO viaje){

        coches trip = new coches();

        // Se crea un nuevo objeto coches a partir de los datos del cochesDTO recibido.
        trip.setModelo(viaje.getModelo());
        trip.setMarca(viaje.getMarca());
        trip.setColor(viaje.getColor());
        trip.setPotencia(viaje.getPotencia());

        // Se guarda el coche en la base de datos.
        tripRepository.save(trip);
    }

    // Método para eliminar coches por modelo.
    public void deleteCoches(String nombre){
        tripRepository.deleteByModelo(nombre);
    }

    // Método para actualizar la información de un coche.
    public void updateCoche(String id, cochesDTO cochesDTO){

        coches trip = null;

        // Se busca el coche por su ID en la base de datos.
        Optional<coches> optionalTrip = tripRepository.findById(id);
        if (optionalTrip.isPresent()) {
            trip = optionalTrip.get();
        } else {
            // Si el coche no existe, no se hace nada.
            return;
        }

        // Se actualizan los campos del coche con los datos del cochesDTO.
        trip.setModelo(cochesDTO.getModelo());
        trip.setMarca(cochesDTO.getMarca());
        trip.setColor(cochesDTO.getColor());
        trip.setPotencia(cochesDTO.getPotencia());

        // Se guarda el coche actualizado en la base de datos.
        tripRepository.save(trip);
    }
}
