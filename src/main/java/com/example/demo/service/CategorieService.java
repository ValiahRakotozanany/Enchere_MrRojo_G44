/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.Categorie;
import com.example.demo.model.CategorieStat;
import java.util.List;

/**
 *
 * @author Murphy
 */
public interface CategorieService {
    public void saveCategorie (Categorie categorie);
    public List<Categorie> listecategorie();
    public List<CategorieStat> listeCategorieMax();
    //public Admin login (String email,String mdp);
}
