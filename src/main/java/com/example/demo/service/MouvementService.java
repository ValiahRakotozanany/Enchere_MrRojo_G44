/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.Mouvement;
import com.example.demo.model.Rechargement;
import java.util.List;

/**
 *
 * @author Murphy
 */
public interface MouvementService {
    void validationRechargement (int iduser,int etat);
  //  public Admin login (String email,String mdp);
    public Mouvement insertionMouvement(Mouvement mouvement);
      List<Rechargement> demanderechargement();
}
