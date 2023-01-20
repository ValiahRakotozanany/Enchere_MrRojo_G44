/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Avion;
import com.example.demo.service.AvionService;
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
@RequestMapping("/gestionflotte/Avions")
@CrossOrigin
public class AvionController {

    @Autowired
    AvionService avionService;

    @PostMapping()
    public ResponseEntity<Avion> saveAvion(@RequestBody Avion avion) {
        return new ResponseEntity<Avion>(avionService.saveAvion(avion), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Avion> getAllEmployees() {
        return avionService.getAllAvions();
    }

    @GetMapping("{id}")
    public ResponseEntity<Avion> getAvionById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<Avion>(avionService.getAvionById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Avion> updateAvion(@RequestBody Avion avion, @PathVariable(name = "id") Integer id) {
        return new ResponseEntity<Avion>(avionService.updateAvion(avion, id), HttpStatus.OK);
    }

    @PostMapping("/photo/{id}")
    public void updatePhotoAvion(@RequestBody String a, @PathVariable(name = "id")int id ) {        
        avionService.updatePhotoAvion(id, a);
    }
    
     @PostMapping("/{id}")
    public String photo(@PathVariable(name = "id")int id ) {        
       return  avionService.photo(id);
    }
    

    @DeleteMapping
    public ResponseEntity<String> deleteAvion(Integer id) {
        avionService.deleteAvion(id);
        return new ResponseEntity<String>("Avion deleted successfully", HttpStatus.OK);
    }

}
