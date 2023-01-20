/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.model.Commission;
import com.example.demo.model.Enchere;
import com.example.demo.model.Historique;
import com.example.demo.model.Photo;
import com.example.demo.model.Produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ComissionRepository;
import com.example.demo.repository.EnchereRepository;
import com.example.demo.repository.HistoriqueRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.repository.UtilisateurRepository;
import com.example.demo.service.EnchereService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */

@Service

public class EnchereServiceImpl implements EnchereService {

    @Autowired
    EnchereRepository enchereRepository;
    
    @Autowired
    ProduitRepository produitrepository;
    
    @Autowired
    PhotoRepository photorepository;
    
    @Autowired
    UtilisateurRepository utilisateurrepository;
    
    @Autowired
    CategorieRepository categorierepository;
    
    @Autowired
    HistoriqueRepository historiquerepository;
    
    @Autowired
    ComissionRepository comissionRepository;
    
    
    @Override
    public Enchere save(Enchere enchere) {
        return enchereRepository.save(enchere);
    }

    @Override
    public List<Enchere> findAll() {
        return enchereRepository.findAll();
    }
    
    @Override
    public List<Enchere> findByUtilisateur(Integer idutilisateur){
        return enchereRepository.findByUtilisateur(idutilisateur);
    }
    
    @Override
    public List<Produit> findByProduit(Integer idproduit){
        return enchereRepository.findByProduit(idproduit);
    }

    @Override
    public Enchere findById(Integer id) {
        return enchereRepository.findById(id).get();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Enchere save(Produit produit, Enchere enchere, String[] photos) throws Exception {
        Historique historique = new Historique();
        Produit pr = produitrepository.save(produit);
        historique.setProduit(pr);
        enchere.setProduit(pr.getId());
        Enchere echr = enchereRepository.save(enchere);
        historique.setUtilisateur(utilisateurrepository.findById(echr.getUtilisateur()).get());
        historique.setCategorie(categorierepository.findById(pr.getCategorie()).get());
        historique.setEnchere(echr);
        historiquerepository.save(historique);
        System.out.println("tsy mety mijanona");
        for (String ph : photos) {
            Photo photo = new Photo();
            photo.setIdenchere(echr.getId());
            photo.setBase64(ph);
            photorepository.save(photo);
        }
        
        return enchere;
    }

    @Override
    public List<Enchere> rechercheAvance(Enchere echere) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void updateCommsion(double pourcentage) {
        comissionRepository.updatecomission(pourcentage);
    }

    @Override
    public Commission comission() {
        return comissionRepository.findAll().get(0);
    }
    
}
