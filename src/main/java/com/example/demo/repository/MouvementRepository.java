/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Mouvement;
import com.example.demo.model.Rechargement;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Murphy
 */
public interface MouvementRepository extends JpaRepository<Mouvement, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update mouvement set etat = :etat where id = :id", nativeQuery = true)
    void validationrechargement(@Param(value = "id") int id ,@Param(value = "etat") int etat );
    @Query(value = "select * from mouvement where etat = 1 and idutilisateur = :id", nativeQuery = true)
    List<Mouvement> getmouvementByIdUtilisateur(@Param(value = "id") int id );
    
}
