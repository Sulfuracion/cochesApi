package com.dam.apitrabel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam.apitrabel.DTO.cochesDTO;
import com.dam.apitrabel.model.coches;
import com.dam.apitrabel.services.TripService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/trip")
public class cochesController {
    
    @Autowired
    private TripService tripService;

    
    @GetMapping()
    public List<coches> getAllTrips(){
        return tripService.getAllTrips();
    }

    
    @GetMapping("/{escala}")
    public List<coches> geTripsByScale(@PathVariable("escala") int escala){
        return tripService.getTripsByEscala(escala);
    }

    @GetMapping("/search")
    public List<coches> getTripsbyOrigin(
        @RequestParam(name = "origen", required = false) String origen, 
        @RequestParam(name = "destino", required = false) String destino) {

        if (origen != null && destino != null) {
            return tripService.getTripsByOrigenAndDestino(origen, destino);
        }
        else if (origen != null){
            return tripService.getTripsByOrigin(origen);
        }
        else{
            return tripService.getTripsByDestino(destino);
        }
    }
    
    @PostMapping()
    public void postTrips(@RequestBody cochesDTO viaje) {
        
        tripService.postTrips(viaje);
    }
    
    @DeleteMapping("/{nombre}")
    public void deleteTrips(@PathVariable("nombre") String nombre){
        tripService.deleteTrips(nombre);
    }
    
    @PutMapping("/precio/{id}")
    public void putTrips(@PathVariable String id, @RequestBody cochesDTO tripDTO) {
        tripService.updateTrip(id, tripDTO);
    }
}
