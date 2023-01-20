/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.Admin;
import com.example.demo.model.Mouvement;
import com.example.demo.model.Rechargement;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.MouvementRepository;
import com.example.demo.repository.RechargementRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.MouvementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */
@Service
public class MouvementServiceImpl implements MouvementService{

    @Autowired
    MouvementRepository mouvementerepository;

    @Autowired
    RechargementRepository rechargement;
    @Override
    public void validationRechargement(int iduser,int etat) {
        mouvementerepository.validationrechargement(iduser,etat);
    }

    @Override
    public Mouvement insertionMouvement(Mouvement mouvement) {
        return mouvementerepository.save(mouvement);
    }

    @Override
    public List<Rechargement> demanderechargement() {
       return rechargement.demanderechargement();
    }
    
 
    
}
