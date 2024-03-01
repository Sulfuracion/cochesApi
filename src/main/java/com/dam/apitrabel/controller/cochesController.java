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


@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/coches") // Establece la ruta base para todos los endpoints de este controlador
public class CochesController {
    
    @Autowired // Inyecta automáticamente la instancia de CochesService cuando se crea una instancia de CochesController
    private CochesService cochesService;

    // Maneja las solicitudes GET a "/coches", devolviendo una lista de todos los coches disponibles
    @GetMapping()
    public List<Coches> getAllTrips(){
        return cochesService.getAllCoches(); // Llama al servicio para obtener todos los coches
    }

    // Maneja las solicitudes GET a "/coches/{marca}", devolviendo una lista de coches filtrados por marca
    @GetMapping("/{marca}")
    public List<Coches> geTripsByScale(@PathVariable("marca") String marca){
        return cochesService.getCochesByMarca(marca); // Llama al servicio para obtener coches por marca
    }

    // Maneja las solicitudes GET a "/coches/search", permitiendo filtrar coches por marca y/o modelo
    @GetMapping("/search")
    public List<Coches> getTripsbyOrigin(
       @RequestParam(name = "marca", required = false) String marca, 
       @RequestParam(name = "modelo", required = false) String modelo) {
       // Filtra coches por marca y modelo, solo por marca, o solo por modelo dependiendo de los parámetros proporcionados
       if (marca != null && modelo != null) {
           return cochesService.getCochesByMarcaModelo(marca, modelo);
       }
       else if (marca != null){
           return cochesService.getCochesByMarca(marca);
       }
       else{
           return cochesService.getCochesByModelo(modelo);
       }
   }
    
    // Maneja las solicitudes POST a "/coches", para crear un nuevo coche
    @PostMapping()
    public void postTrips(@RequestBody CochesDTO cochesDTO) {
        cochesService.postTrips(cochesDTO); // Llama al servicio para añadir un nuevo coche
    }
    
    // Maneja las solicitudes DELETE a "/coches/{modelo}", para eliminar coches por modelo
    @DeleteMapping("/{modelo}")
    public void deleteCoches(@PathVariable("modelo") String modelo){
        cochesService.deleteCoches(modelo); // Llama al servicio para eliminar coches por modelo
    }
    
    // Maneja las solicitudes PUT a "/coches/precio/{id}", para actualizar la información de un coche específico por su ID
    @PutMapping("/precio/{id}")
    public void putCoches(@PathVariable String id, @RequestBody CochesDTO cochesDTO) {
        cochesService.updateCoche(id, cochesDTO); // Llama al servicio para actualizar un coche por ID
    }
}

