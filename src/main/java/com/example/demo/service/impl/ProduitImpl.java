/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.Admin;
import com.example.demo.model.Categorie;
import com.example.demo.model.Produit;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.CategorieService;
import com.example.demo.service.ProduitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */
@Service
public class ProduitImpl implements ProduitService{

    @Autowired
    ProduitRepository produitrepository;

    

    @Override
    public void saveProduit(Produit produit) {
        produitrepository.save(produit);
    }

    @Override
    public List<Produit> listeProduit() {
        return produitrepository.findAll();
    }

    @Override
    public Produit save(Produit produit) {
     return  produitrepository.save(produit);
    }
    
}
