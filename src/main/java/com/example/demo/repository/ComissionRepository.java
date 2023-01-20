/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Admin;
import com.example.demo.model.CategorieStat;
import com.example.demo.model.Commission;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
/**
 *
 * @author Murphy
 */
public interface ComissionRepository extends JpaRepository<Commission, Integer> {

    @Query(value = "Select * from comission", nativeQuery = true)
    public Commission comission();

    @Transactional
    @Modifying
    @Query(value = "update comission set pourcentage = :pourcentage", nativeQuery = true)
    public void updatecomission(@Param(value = "pourcentage") double pourcentage);
}
