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
import javax.servlet.http.HttpServletRequest;
import lombok.Data;

/**
 *
 * @author Valiah Karen
 */
@Data
@Entity
@Table(name = "tokenadmin")
public class TokenAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "token")
    private String token;

    @Column(name = "expiration")
    private Timestamp dateExpiration;

    @Column(name = "idadmin")
    private int utilisateurid;

    public static final long DateEXP = 230082253;
    public static final String keyToken = "Token22";

    public String CreerToken() {
        long now = System.currentTimeMillis();
        System.out.println("now  " + now);
        Date dt = new Date(now + TokenAdmin.DateEXP);
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, TokenAdmin.keyToken)
                .setIssuedAt(new Date(now))
                .setExpiration(dt)
                .claim("idadmin", this.getUtilisateurid())
                .compact();
        System.out.println(" token = " + token.split("\\.")[2]);
        return token;
    }
//public static final long TOKEN_VALIDITY = 2*60*60*100*120;

    public static void verifierToken(String tok, HttpServletRequest request) throws Exception {
        //String[] authHeaderArr = authHeader.split("Bearer");

        if (tok != null) {
            String token = tok;
            try {
              /*  Claims claims = Jwts.parser().setSigningKey(TokenAdmin.keyToken)
                        .parseClaimsJws(token).getBody();
                System.out.println(" Mety ");
                request.setAttribute("idadmin", Integer.parseInt(claims.get("idadmin").toString()));*/
                System.out.println("Mety");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                //throw new Exception("Token invalid/veuillez vous reconnecter");
            }
        } else {
            throw new Exception("Token invalid/veuillez vous reconnecter");
        }
    }

    public static void verifierTokenClient(String authHeader, HttpServletRequest request) throws Exception {
       // String[] authHeaderArr = authHeader.split("Bearer");
        System.out.println(" authHeader = "+authHeader);
       // if (authHeaderArr.length > 1 && authHeaderArr[1] != null) {
       if(authHeader!=null){
            String token = authHeader;
            try {
                Claims claims = Jwts.parser().setSigningKey(TokenAdmin.keyToken)
                        .parseClaimsJws(token).getBody();
                System.out.println(" mety ve ??????");
                request.setAttribute("idadmin", Integer.parseInt(claims.get("idadmin").toString()));
                System.out.println(claims + token);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                throw new Exception("Token invalid/expired");
            }
        } else {
            throw new Exception("Token invalid/expired");
        }
    }
}
