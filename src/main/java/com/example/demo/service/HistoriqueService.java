/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.FicheEchere;
import com.example.demo.model.Historique;
import java.util.List;

/**
 *
 * @author Murphy
 */


public interface HistoriqueService {
    public Historique save (Historique historique);
    public List<Historique> findAll();
    public List<Historique> findByUtilisateur(Integer idutilisateur);
}
