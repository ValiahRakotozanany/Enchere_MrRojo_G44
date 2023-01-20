/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Vehicule;
import java.util.List;

/**
 *
 * @author Murphy
 */
public interface VehiculeService {
    Vehicule saveVehicule (Vehicule vehicule);
    List<Vehicule> getAllVehicules();
    Vehicule getVehiculeById (Integer id);
    Vehicule updateVehicule(Vehicule vehicule,Integer id);
    void deleteVehicule(Integer id);
}
