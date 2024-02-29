package com.dam.apitrabel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.apitrabel.DTO.cochesDTO;
import com.dam.apitrabel.model.coches;
import com.dam.apitrabel.repositories.cochesRepository;

@Service
public class CochesService {
    
    @Autowired
    private cochesRepository tripRepository;

    public List<coches> getAllCoches(){
        return tripRepository.findAll();
    }

    public List<coches> getTripsByPotencia(int potencia){
        return tripRepository.findByPotencia(potencia);
    }

    public List<coches> getCochesByMarca(String marca){
        return tripRepository.findByMarca(marca);
    }

    public List<coches> getCochesByMarcaModelo(String modelo, String marca){
        return tripRepository.findByMarcaModelo(modelo, marca);
    }

    public List<coches> getCochesByModelo(String modelo){
        return tripRepository.findByModelo(modelo);
    }

    public void postTrips(cochesDTO viaje){

        coches trip = new coches();

        //Se deveria comprobar que campos son nulos
        trip.setModelo(viaje.getModelo());
        trip.setMarca(viaje.getMarca());
        trip.setColor(viaje.getColor());
        trip.setPotencia(viaje.getPotencia());

        tripRepository.save(trip);
    }

    public void deleteCoches(String nombre){
        tripRepository.deleteByModelo(nombre);
    }

    public void updateCoche(String id, cochesDTO cochesDTO){

        coches trip = null;

        if (tripRepository.findById(id) != null) {
            trip = tripRepository.findById(id).get();
        }
        else{
            return;
        }

        tripRepository.save(trip);
    }
}
