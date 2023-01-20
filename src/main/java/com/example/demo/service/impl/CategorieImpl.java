/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.Admin;
import com.example.demo.model.Categorie;
import com.example.demo.model.CategorieStat;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.CategorieStatRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.CategorieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */
@Service
public class CategorieImpl implements CategorieService{

    @Autowired
    CategorieRepository categorierepository;

     @Autowired
     CategorieStatRepository categoristat;

    
    @Override
    public void saveCategorie(Categorie categorie) {
        categorierepository.save(categorie);
    }    

    @Override
    public List<Categorie> listecategorie() {
        return categorierepository.findAll();
    }

    @Override
    public List<CategorieStat> listeCategorieMax() {
        return categoristat.categorieDuMois();
    }
    
}
