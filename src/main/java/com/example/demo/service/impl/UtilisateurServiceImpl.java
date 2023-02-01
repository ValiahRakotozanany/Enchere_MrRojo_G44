/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.FicheEchere;
import com.example.demo.model.Mouvement;
import com.example.demo.model.Admin;
import com.example.demo.model.Utilisateur;
import com.example.demo.repository.FicheEchereRepository;
import com.example.demo.repository.MouvementRepository;
import com.example.demo.repository.UtilisateurRepository;
import com.example.demo.service.UtilisateurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurService
{
    @Autowired
    UtilisateurRepository utilisateurRepository;
    
    @Autowired
    MouvementRepository mr;
    @Autowired
    FicheEchereRepository fe;
    
    @Override
    public double getsolde(int idutilisateur) {
        List<FicheEchere> fiche= fe.getFicheEchereByIdUtilisateur(idutilisateur);
        List<Mouvement> mvt= mr.getmouvementByIdUtilisateur(idutilisateur);
        double vfiche=0;
        double vmvt=0;
        for(int i=0;i<fiche.size();i++){
            vfiche=vfiche+fiche.get(i).getMontant();
        }
        
        for(int i=0;i<mvt.size();i++){
            vmvt+= mvt.get(i).getMontant();
        }
        System.out.println(" montant mouvement = "+vmvt+" _ enchere= "+vfiche);
        return vmvt - vfiche;
    }
    

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
    public Utilisateur save(Utilisateur admin) {
       return utilisateurRepository.save(admin);     
    }

    @Override
    public Utilisateur login(String email, String mdp) {
        return utilisateurRepository.findByEmailAndMotdepasse(email,mdp);
    }

    @Override
    public Utilisateur findById(Integer id) {
        return utilisateurRepository.findById(id).get();
    }
    
    
}
