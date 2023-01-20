/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Murphy
 */
public interface AdminRepository extends JpaRepository<Admin,Integer>{
    

    @Query(value="Select * from admin where email = :email and password= :mdp",nativeQuery = true)
    public Admin findByEmailAndMotdepasse (@Param(value = "email")String email,@Param(value = "mdp")String mdp);
}
