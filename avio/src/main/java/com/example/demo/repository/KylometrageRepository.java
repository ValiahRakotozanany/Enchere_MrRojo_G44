/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Kylometrage;
import com.example.demo.model.Avion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Murphy
 */
public interface KylometrageRepository extends JpaRepository<Kylometrage,Integer> {
        public List<Kylometrage> findByAvionOrderByIdDesc (Avion vehicule);
        public List<Kylometrage> findByAvion (Avion vehicule);
}
