/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Kylometrage;
import com.example.demo.model.Vehicule;
import java.util.List;

/**
 *
 * @author Murphy
 */
public interface KylometrageService {
    Kylometrage saveKylometrage (Kylometrage kylometrage);
    List<Kylometrage> getAllKylometrages();
    Kylometrage getKylometrageById (Integer id);
    Kylometrage updateKylometrage(Kylometrage vehicule,Integer id);
    void deleteKylometrage(Integer id);
}
