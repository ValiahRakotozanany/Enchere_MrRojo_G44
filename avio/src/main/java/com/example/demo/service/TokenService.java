/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Token;
import java.sql.Timestamp;
import javax.persistence.Entity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Valiah Karen
 */

public interface TokenService {    
    Token findByUtilisateurid(int utilisateurid);
    void updateTokenAndExpiration(String token,Timestamp expiration,int id);  
    Token saveToken(Token token);
    Timestamp addDateTime(Timestamp tm, Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second);
    
}
