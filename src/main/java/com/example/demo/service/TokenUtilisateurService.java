/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.TokenUtilisateur;
import java.sql.Timestamp;

/**
 *
 * @author hp
 */
public interface TokenUtilisateurService {
    TokenUtilisateur findByidUtilisateur(int utilisateurid);

    void updateTokenAndExpirationUtilisateur(String token, Timestamp expiration, int id);

    TokenUtilisateur saveTokenUtilisateur(TokenUtilisateur token);
    
    Timestamp addDateTime(Timestamp tm, Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second);
}
