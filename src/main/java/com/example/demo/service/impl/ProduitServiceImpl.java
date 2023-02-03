/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.model.Produit;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.service.ProduitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */

@Service

public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;
    
    @Override
    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void saveProduit(Produit produit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produit> listeProduit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
