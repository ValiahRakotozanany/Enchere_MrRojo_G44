/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Avion;
import java.sql.Timestamp;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Murphy
 */
public interface AvionRepository extends JpaRepository<Avion,Integer> {
      @Transactional
    @Modifying
    @Query(value = "update avion set photo = :photo where id = :id", nativeQuery = true)
    void updateAvionPhoto(@Param(value = "id") int id, @Param(value = "photo") String photo);

    @Query(value = "Select photo from avion where id = :id", nativeQuery = true)
    String photo(@Param(value = "id") int id);

    
}
