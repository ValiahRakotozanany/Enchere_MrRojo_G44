/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.Token;
import com.example.demo.service.AdminService;
import com.example.demo.service.TokenService;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Murphy
 */
@RestController
@RequestMapping("/gestionflotte/admins")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    TokenService tokService;

    @PostMapping()
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public Token login(@RequestBody Admin admin) throws Exception {
        Admin d = null;                
        d=adminService.login(admin.getEmail(), admin.getMotdepasse());
        Token t = new Token();
        System.out.println(" amind = "+d);
        if (d != null) {            
            t.setUtilisateurid(d.getId());
            return this.testToken(t);
        }
        else{
            throw new Exception ("Incorrecte !!");
        }
    }
    
    
    @PostMapping("/login/{email}/{mdp}")
    public Token log(@PathVariable(name="email")String email,@PathVariable(name="mdp") String mdp) throws Exception {
        Admin d = null;                
        d=adminService.login(email, mdp);
        Token t = new Token();
        System.out.println(" amind = "+d);
        if (d != null) {            
            t.setUtilisateurid(d.getId());
            return this.testToken(t);
        }
        else{
            throw new Exception ("Incorrecte !!");
        }
    }

//    @GetMapping("/token/{idU}")
//    public String CreerToken(@PathVariable(name = "idU") String idU) {
//        int idUtilisateur = Integer.parseInt(idU);
//        Token token = new Token();
//        return token.CreerToken(idUtilisateur);
//    }

    public Token testToken(Token tok) {
        Token token = new Token();
        System.out.println(" idddd = " + tok);
        token.setUtilisateurid(tok.getUtilisateurid());
        LocalDateTime localDate = LocalDateTime.now();
        Timestamp now = Timestamp.valueOf(localDate);
        token = tokService.findByUtilisateurid(tok.getUtilisateurid());

        if ( token == null) {
            now = tokService.addDateTime(now,null,null,null,null,5,null);
            token = new Token();
            //System.out.println(" toke "+t.CreerToken(1));
            token.setDateExpiration(now);
            token.setUtilisateurid(tok.getUtilisateurid());
            token.setToken(token.CreerToken());
        } else {
            Timestamp date = token.getDateExpiration();
            System.out.println("nowww " + now);
            System.out.println(" date " + date);
            if (now.after(date)) {
                now = tokService.addDateTime(now,null,null,null,null,5,null);
                System.out.println(" now = " + now);
                date = now;
                token.setToken(token.CreerToken());
                token.setDateExpiration(now);
            }
        }
         return tokService.saveToken(token);
    }

}
