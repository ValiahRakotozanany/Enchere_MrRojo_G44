/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Avion;
import java.util.List;

/**
 *
 * @author Murphy
 */
public interface AvionService {
    Avion saveAvion (Avion avion);
    List<Avion> getAllAvions();
    Avion getAvionById (Integer id);
    Avion updateAvion(Avion avion,Integer id);
    void deleteAvion(Integer id);
}
