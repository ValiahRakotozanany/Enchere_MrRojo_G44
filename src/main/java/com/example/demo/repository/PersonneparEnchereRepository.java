/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Admin;
import com.example.demo.model.CategorieStat;
import com.example.demo.model.PersonneparEnchere;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Murphy
 */
public interface PersonneparEnchereRepository extends JpaRepository<PersonneparEnchere,Integer>{
    

    @Query(value="Select * from nombrepersonneparEnchere",nativeQuery = true)
    public List<PersonneparEnchere> nombrepersonneparEnchere ();
}
