/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.AssuranceVehicule;
import com.example.demo.service.AssuranceVehiculeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Valiah Karen
 */
@RestController
@RequestMapping("/assurance")
@CrossOrigin("*")

public class AssuranceVehiculeController {

    @Autowired
    AssuranceVehiculeService avs;
    

    @PostMapping("Assurance1")
    public List<AssuranceVehicule> assurance1mois() {
        List<AssuranceVehicule> assurance = avs.findAll();
        List<AssuranceVehicule> assurance1 = new ArrayList<>();
        for (int i = 0; i < assurance.size(); i++) {
            if (assurance.get(i).getJourMois() <= 31) {
                assurance1.add(assurance.get(i));
            }
        }
        return assurance1;
    }

    @PostMapping("Assurance3")
    public List<AssuranceVehicule> assurance3mois() {
        List<AssuranceVehicule> assurance = avs.findAll();
        List<AssuranceVehicule> assurance1 = new ArrayList<>();
        for (int i = 0; i < assurance.size(); i++) {
            if (assurance.get(i).getJourMois() <= 93 && assurance.get(i).getJourMois() >= 32) {
                assurance1.add(assurance.get(i));
            }
        }
        return assurance1;
    }
}
