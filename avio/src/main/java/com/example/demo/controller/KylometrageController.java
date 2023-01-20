/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Kylometrage;
import com.example.demo.model.Avion;
import com.example.demo.service.KylometrageService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Murphy
 */

@RestController
@RequestMapping("/gestionflotte/kylometrages")
@CrossOrigin
public class KylometrageController {
    
    @Autowired
    KylometrageService kylometrageService;
    

    

    @PostMapping()
    public ResponseEntity<Kylometrage> saveKylometrage (@RequestBody Kylometrage kylometrage) {
        return new ResponseEntity<Kylometrage>(kylometrageService.saveKylometrage(kylometrage),HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Kylometrage> getAllKylometrages (@RequestBody Avion avion) {
        return kylometrageService.getAllKylometrages(avion);
    }

    @GetMapping("/query")
    public List<Kylometrage> getKylometragesByIdvehicule (@RequestParam("idavion") Integer idavion) {
        Avion avion = new Avion();
        avion.setId(idavion);
        return kylometrageService.getAllKylometrages(avion);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Kylometrage> getKylometrageById (@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<Kylometrage>(kylometrageService.getKylometrageById(id),HttpStatus.OK);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Kylometrage> updateKylometrage (@RequestBody Kylometrage kylometrage,@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<Kylometrage>(kylometrageService.updateKylometrage(kylometrage,id),HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity<String> deleteKylometrage (Integer id) {
        kylometrageService.deleteKylometrage(id);
        return new ResponseEntity<String>("Kylometrage deleted successfully",HttpStatus.OK);
    }
    
}
