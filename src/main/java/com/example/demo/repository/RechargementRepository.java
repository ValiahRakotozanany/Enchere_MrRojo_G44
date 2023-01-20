/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Admin;
import com.example.demo.model.Rechargement;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Murphy
 */
public interface RechargementRepository extends JpaRepository<Rechargement,Integer>{
    

    @Query(value="Select * from rechargement where etat = 0",nativeQuery = true)
    public List<Rechargement> demanderechargement ();
}
