package com.dam.apitrabel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.apitrabel.DTO.cochesDTO;
import com.dam.apitrabel.model.coches;
import com.dam.apitrabel.repositories.cochesRepository;

@Service
public class TripService {
    
    @Autowired
    private cochesRepository tripRepository;

    public List<coches> getAllTrips(){
        return tripRepository.findAll();
    }

    public List<coches> getTripsByEscala(int escala){
        return tripRepository.findByEscala(escala);
    }

    public List<coches> getTripsByOrigin(String origin){
        return tripRepository.findByOrigen(origin);
    }

    public List<coches> getTripsByOrigenAndDestino(String origen, String destino){
        return tripRepository.findByOrigenAndDestino(origen, destino);
    }

    public List<coches> getTripsByDestino(String destino){
        return tripRepository.findByDestino(destino);
    }

    public void postTrips(cochesDTO viaje){

        coches trip = new coches();

        //Se deveria comprobar que campos son nulos
        trip.setNombre(viaje.getNombre());
        trip.setOrigen(viaje.getDestino());
        trip.setDestino(viaje.getDestino());
        trip.setEscala(viaje.getEscala());
        trip.setDuracion(viaje.getDuracion());
        trip.setPrecio(viaje.getPrecio());

        tripRepository.save(trip);
    }

    public void deleteTrips(String nombre){
        tripRepository.deleteByNombre(nombre);
    }

    public void updateTrip(String id, cochesDTO tripDTO){

        coches trip = null;

        if (tripRepository.findById(id) != null) {
            trip = tripRepository.findById(id).get();
        }
        else{
            return;
        }

        trip.setPrecio(tripDTO.getPrecio());

        tripRepository.save(trip);
    }
}
