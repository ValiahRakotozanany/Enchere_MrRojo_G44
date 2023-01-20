/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Token;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Valiah Karen
 */
public interface TokenRepository extends JpaRepository<Token, Integer> {

    public Token findByUtilisateurid(int utilisateurid);

    /*@Modifying
    @Query("update token set expiration = :expiration and token = :token where utilisateurid= :idU")
    void updateToken(@Param("token") String token, @Param("expiration") Timestamp expiration, @Param("idU") int id);*/
    /**
     *
     */
    @Transactional
    @Modifying
    @Query(value = "update token set expiration = :expiration , token = :token where utilisateurid = :idU", nativeQuery = true)
    void updateToken(@Param(value = "token") String token, @Param(value = "expiration") Timestamp expiration, @Param(value = "idU") int id);
}
