/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Kylometrage;
import com.example.demo.model.Vehicule;
import com.example.demo.repository.KylometrageRepository;
import com.example.demo.service.KylometrageService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */

@Service
public class KylometrageServiceImpl implements KylometrageService{
    
    @Autowired
    KylometrageRepository kylometrageRepository;
    
    @Override
    public Kylometrage saveKylometrage(Kylometrage kylometrage) {
        List<Kylometrage> kylometrageVehicule = kylometrageRepository.findByVehiculeOrderByIdDesc(kylometrage.getVehicule());
        if (kylometrageVehicule.size()== 0) {
            kylometrage.setKmdebut(0.0);
            return kylometrageRepository.save(kylometrage);
        }
        Kylometrage lastKylometrage = kylometrageVehicule.get(0);
        if (kylometrage.getKmdebut() == null) {
            kylometrage.setKmdebut(lastKylometrage.getKmfin());
        }
        else if (kylometrage.getKmdebut() > lastKylometrage.getKmfin()  ) {
            Kylometrage newKylometrage = new Kylometrage();
            newKylometrage.setDates(kylometrage.getDates());
            newKylometrage.setKmdebut(lastKylometrage.getKmfin());
            newKylometrage.setKmfin(kylometrage.getKmdebut());
            kylometrageRepository.save(newKylometrage);
        }
        
        else if (kylometrage.getKmdebut() < lastKylometrage.getKmfin()) {
            try {
                throw new Exception("la dernière kylometrage est "+lastKylometrage.getKmfin());
            } catch (Exception ex) {
                Logger.getLogger(KylometrageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return kylometrageRepository.save(kylometrage);
    }

    @Override
    public List<Kylometrage> getAllKylometrages() {
        return kylometrageRepository.findAll();
    }

    @Override
    public Kylometrage getKylometrageById(Integer id) {
        Optional<Kylometrage> kylometre = kylometrageRepository.findById(id);
        if (!kylometre.isPresent()) {
            try {
                throw new ResourceNotFoundException("Kylometrage","Id",id);
            } catch (ResourceNotFoundException ex) {
                Logger.getLogger(KylometrageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return kylometre.get();
    }

    @Override
    public Kylometrage updateKylometrage(Kylometrage kylometrage, Integer id) {
        Kylometrage existing = getKylometrageById(id);
        existing.setDates(kylometrage.getDates());
        existing.setKmdebut(kylometrage.getKmdebut());
        existing.setKmfin(kylometrage.getKmfin());
        return saveKylometrage(existing);
    }

    @Override
    public void deleteKylometrage(Integer id) {
        kylometrageRepository.deleteById(id);
    }
    
}
