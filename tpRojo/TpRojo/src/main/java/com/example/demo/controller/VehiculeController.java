/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Vehicule;
import com.example.demo.service.VehiculeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Murphy
 */

@RestController
@RequestMapping("/gestionflotte/vehicules")
@CrossOrigin("*")
public class VehiculeController {
    
    @Autowired
    VehiculeService vehiculeService;
    
    @PostMapping()
    public ResponseEntity<Vehicule> saveVehicule (@RequestBody Vehicule vehicule) {
        return new ResponseEntity<Vehicule>(vehiculeService.saveVehicule(vehicule),HttpStatus.CREATED);
    }
    @GetMapping
    public List<Vehicule> getAllVehicules () {
        return vehiculeService.getAllVehicules();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Vehicule> getVehiculeById (@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<Vehicule>(vehiculeService.getVehiculeById(id),HttpStatus.OK);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Vehicule> updateVehicule (@RequestBody Vehicule vehicule,@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<Vehicule>(vehiculeService.updateVehicule(vehicule,id),HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity<String> deleteVehicule (Integer id) {
        vehiculeService.deleteVehicule(id);
        return new ResponseEntity<String>("vehicule deleted successfully",HttpStatus.OK);
    }
    
}
