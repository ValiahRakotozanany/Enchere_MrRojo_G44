/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Commission;
import com.example.demo.model.Enchere;
import com.example.demo.model.Produit;
import java.util.List;

/**
 *
 * @author Murphy
 */
public interface EnchereService {
    public Enchere save (Enchere enchere);
    public List<Enchere> findAll ();
    public List<Enchere> findByUtilisateur(Integer idutilisateur);
    public List<Produit> findByProduit (Integer idproduit);
    public Enchere findById (Integer id);
    public Enchere save (Produit produit,Enchere enchere,String[] photo) throws Exception ;
    public List<Enchere> rechercheAvance (Enchere echere); public void updateCommsion(double pourcentage);
    public List<Enchere> getEnchereActif ();
    public Commission comission();
   
 }
