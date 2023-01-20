/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Avion;
import com.example.demo.repository.AvionRepository;
import com.example.demo.service.AvionService;
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
public class AvionServiceImpl implements AvionService{

    AvionRepository avionRepository;

    public AvionServiceImpl(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }
    
    @Override
    public Avion  saveAvion(Avion avion) {
        return avionRepository.save(avion);
    }


    @Override
    public List<Avion> getAllAvions() {
        return avionRepository.findAll();
    }

    @Override
    public Avion getAvionById(Integer id) {
        Optional<Avion> avion = avionRepository.findById(id);
        if (!avion.isPresent()) {
            try {
                throw new ResourceNotFoundException("Avion","Id",id);
            } catch (ResourceNotFoundException ex) {
                Logger.getLogger(AvionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return avion.get();
    }

    @Override
    public Avion updateAvion(Avion avion, Integer id) {
        Optional<Avion> existingavion = avionRepository.findById(id);
        if (!existingavion.isPresent()) {
            try {
                throw new ResourceNotFoundException("Avion","Id",id);
            } catch (ResourceNotFoundException ex) {
                Logger.getLogger(AvionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Avion existAvion = existingavion.get();
        existAvion.setMatricule(avion.getMatricule());
        existAvion.setNom(avion.getNom());
        avionRepository.save(existAvion);
        return existAvion;
    }

    @Override
    public void deleteAvion(Integer id) {
        avionRepository.deleteById(id);
    }

    
}
