/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Produit;

import com.example.demo.model.Admin;
import com.example.demo.model.Categorie;
import com.example.demo.model.Produit;
import java.util.List;

/**
 *
 * @author Murphy
 */
public interface ProduitService {
    
    public Produit save (Produit produit) ;
    
    public void saveProduit (Produit produit);
    public List<Produit> listeProduit();
    //public Admin login (String email,String mdp);
}
