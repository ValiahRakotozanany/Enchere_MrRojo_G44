/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Utilisateur;
import org.springframework.stereotype.Service;


import com.example.demo.model.Admin;
import com.example.demo.model.Utilisateur;

/**
 *
 * @author Murphy
 */
public interface UtilisateurService {
    public Utilisateur saveUtilisateur (Utilisateur admin);
    public Utilisateur login (String email,String mdp);
    public double getsolde(int idutilisateur);
    public Double getSoldeBase(int idutilisateur);
    public Utilisateur save (Utilisateur admin);
    public Utilisateur findById(Integer id);
}
