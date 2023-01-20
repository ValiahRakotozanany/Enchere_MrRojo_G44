/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.model.Historique;
import com.example.demo.model.Utilisateur;
import com.example.demo.repository.HistoriqueRepository;
import com.example.demo.repository.UtilisateurRepository;
import com.example.demo.service.HistoriqueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */

@Service

public class HistoriqueServiceImpl implements HistoriqueService {

    @Autowired
    UtilisateurRepository utilisateurRepository;
    
    @Autowired
    HistoriqueRepository historiquerepository;
    
    @Override
    public Historique save(Historique historique) {
        return historiquerepository.save(historique);
    }

    @Override
    public List<Historique> findAll() {
        return historiquerepository.findAll();
    }

    @Override
    public List<Historique> findByUtilisateur(Integer idutilisateur) {
        Utilisateur u = utilisateurRepository.findById(idutilisateur).get();
        return historiquerepository.findByUtilisateur(u);
    }
    
}
