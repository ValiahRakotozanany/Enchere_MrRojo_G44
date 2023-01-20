package com.example.demo.model;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.Date;
import io.jsonwebtoken.Claims;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "token")
public class Token {
    
    public static final long DateEXP = 43200;
    public static final String keyToken = "Token22";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String token;
    private Date dateexpiration;
    @Column(name = "idAdmin")
    private int idAdmin;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDateexpiration() {
        return this.dateexpiration;
    }

    public void setDateexpiration(Date exp) {
        this.dateexpiration = exp;
    }
    

    public Token CreerToken(int utilisateurid) {
        long now = System.currentTimeMillis();
        this.setDateexpiration(new Date(now + Token.DateEXP));
        this.setToken( Jwts.builder().signWith(SignatureAlgorithm.HS256, Token.keyToken)
                .setIssuedAt(new Date(now))
                .setExpiration(this.getDateexpiration())
                .claim("idAdmin",utilisateurid)
                .compact()
        );
        return this;
    }

}
