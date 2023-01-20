/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Admin;
import com.example.demo.model.CategorieStat;
import com.example.demo.model.Chiffreenchere;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Murphy
 */

public interface ChiffreenchereRepository extends JpaRepository<Chiffreenchere,Integer>{
    

        @Query(value="Select * from chiffrerapporteEnchere order by nombreuser desc limit 3",nativeQuery = true)
    public List<Chiffreenchere> enchereplusenvie ();
    
    
        @Query(value="Select * from chiffrerapporteEnchere order by chiffre desc limit 4",nativeQuery = true)
    public List<Chiffreenchere> chiffremaxenchere();
    }
