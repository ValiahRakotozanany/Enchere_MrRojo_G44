/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.TokenUtilisateur;
import java.sql.Timestamp;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author hp
 */
public interface TokenUtilisateurRepository extends JpaRepository<TokenUtilisateur,Integer>{
    @Transactional
    @Modifying
    @Query(value = "update tokenutilisateur set expiration = :expiration , token = :token where idutilisateur = :idU", nativeQuery = true)
    void updateTokenUtilisateur(@Param(value = "token") String token, @Param(value = "expiration") Timestamp expiration, @Param(value = "idU") int id);

    @Query(value = "select * from tokenutilisateur where idutilisateur = :idU", nativeQuery = true)
    TokenUtilisateur tokenUtilisateur( @Param(value = "idU") int id);
}
