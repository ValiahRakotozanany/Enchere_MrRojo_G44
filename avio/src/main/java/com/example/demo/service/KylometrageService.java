/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Kylometrage;
import com.example.demo.model.Avion;
import java.util.List;

/**
 *
 * @author Murphy
 */
public interface KylometrageService {
    Kylometrage saveKylometrage (Kylometrage kylometrage);
    List<Kylometrage> getAllKylometrages(Avion vehicule);
    Kylometrage getKylometrageById (Integer id);
    Kylometrage updateKylometrage(Kylometrage kylometrage,Integer id);
    void deleteKylometrage(Integer id);
}
