/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Vehicule;
import com.example.demo.repository.VehiculeRepository;
import com.example.demo.service.VehiculeService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */
@Service
public class VehiculeServiceImpl implements VehiculeService{

    VehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }
    
    @Override
    public Vehicule  saveVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule getVehiculeById(Integer id) {
        Optional<Vehicule> vehicule = vehiculeRepository.findById(id);
        if (!vehicule.isPresent()) {
            try {
                throw new ResourceNotFoundException("Vehicule","Id",id);
            } catch (ResourceNotFoundException ex) {
                Logger.getLogger(VehiculeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return vehicule.get();
    }

    @Override
    public Vehicule updateVehicule(Vehicule vehicule, Integer id) {
        Optional<Vehicule> existingvehicule = vehiculeRepository.findById(id);
        if (!existingvehicule.isPresent()) {
            try {
                throw new ResourceNotFoundException("Vehicule","Id",id);
            } catch (ResourceNotFoundException ex) {
                Logger.getLogger(VehiculeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Vehicule existVehicule = existingvehicule.get();
        existVehicule.setMatricule(vehicule.getMatricule());
        existVehicule.setNom(vehicule.getNom());
        vehiculeRepository.save(existVehicule);
        return existVehicule;
    }

    @Override
    public void deleteVehicule(Integer id) {
        vehiculeRepository.deleteById(id);
    }

    
}
