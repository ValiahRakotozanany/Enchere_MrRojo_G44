/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Murphy
 */
public interface ProduitRepository extends JpaRepository<Produit,Integer>{
    
}
