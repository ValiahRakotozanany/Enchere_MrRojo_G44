/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Kylometrage;
import com.example.demo.model.Vehicule;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Murphy
 */
public interface KylometrageRepository extends JpaRepository<Kylometrage,Integer> {
        
           @Query(value = "select *from Kylometrage where id_vehicule = :idvehicule order by id desc limit 1 ", nativeQuery = true)
    public List<Kylometrage> findKylometrageByIdVehicule(@Param(value = "idvehicule") int idVehicule);
   
        
       // public List<Kylometrage> findByVehicule (int vehicule);
}
