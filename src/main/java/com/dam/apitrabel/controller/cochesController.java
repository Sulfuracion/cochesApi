package com.dam.apitrabel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam.apitrabel.DTO.cochesDTO;
import com.dam.apitrabel.model.coches;
import com.dam.apitrabel.services.CochesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/coches")
public class cochesController {
    
    @Autowired
    private CochesService cochesService;

    
    @GetMapping()
    public List<coches> getAllTrips(){
        return cochesService.getAllCoches();
    }

    
    @GetMapping("/{marca}")
    public List<coches> geTripsByScale(@PathVariable("marca") String marca){
        return cochesService.getCochesByMarca(marca);
    }

   //@GetMapping("/search")
   //public List<coches> getTripsbyOrigin(
   //    @RequestParam(name = "origen", required = false) String marcar, 
   //    @RequestParam(name = "destino", required = false) String modelo) {
//
   //    if (marcar != null && modelo != null) {
   //        return cochesService.getCochesByMarcaModelo(marcar, modelo);
   //    }
   //    else if (marcar != null){
   //        return cochesService.getCochesByModelo(marcar);
   //    }
   //    else{
   //        return cochesService.getCochesByModelo(modelo);
   //    }
   //}
    
   @PostMapping()
   public void postTrips(@RequestBody cochesDTO viaje) {
       cochesService.postTrips(viaje);
   }
    
    @DeleteMapping("/{modelo}")
    public void deleteCoches(@PathVariable("modelo") String nombre){
        cochesService.deleteCoches(nombre);
    }
    
    @PutMapping("/precio/{id}")
    public void putCoches(@PathVariable String id, @RequestBody cochesDTO tripDTO) {
        cochesService.updateCoche(id, tripDTO);
    }
}
