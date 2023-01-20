/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.Date;
import io.jsonwebtoken.Claims;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Valiah Karen
 */
@Data
@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;    
    @Column(name = "token")
    private String token;

    @Column(name = "expiration")
    private Timestamp dateExpiration;

    @Column(name = "utilisateurid")
    private int utilisateurid;

    public static final long DateEXP = 50000;
    public static final String keyToken = "Token22";

    public String CreerToken() {
        long now = System.currentTimeMillis();
        System.out.println("now  "+now);
        Date dt = new Date(now + Token.DateEXP);
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Token.keyToken)
                .setIssuedAt(new Date(now))
                .setExpiration(dt)
                .claim("idutilisateur", utilisateurid)
                .compact();
        System.out.println(" token = " + token.split("\\.")[2]);
        return token.split("\\.")[2];
    }

}
