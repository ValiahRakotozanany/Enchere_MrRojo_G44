/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Murphy
 */
//public interface PhotoRepository extends MongoRepository<Photo,String> {
public interface PhotoRepository extends JpaRepository<Photo,Integer> {
    
}
