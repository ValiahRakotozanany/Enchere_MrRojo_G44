/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.Categorie;
import com.example.demo.model.CategorieStat;
import com.example.demo.model.Chiffreenchere;
import com.example.demo.model.Commission;
import com.example.demo.model.Produit;
import com.example.demo.model.Rechargement;
import com.example.demo.model.TokenAdmin;
import com.example.demo.service.AdminService;
import com.example.demo.service.CategorieService;
import com.example.demo.service.EnchereService;
import com.example.demo.service.MouvementService;
import com.example.demo.service.ProduitService;
import com.example.demo.service.TokenService;
import com.example.demo.service.impl.ProduitImpl;
import com.example.demo.service.impl.StatistiqueServiceImpl;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Murphy
 */
@RestController
@CrossOrigin("*")
public class ProduitCategorieController {

    @Autowired
    AdminService adminService;

    @Autowired
    TokenService tokService;

    @Autowired
    MouvementService mouvementservice;

    @Autowired
    CategorieService categorieservice;

    @Autowired
    EnchereService enchereservice;

    @Autowired
    StatistiqueServiceImpl stat;
   
   
    @Autowired
    ProduitImpl produit;
            
    TokenAdmin tokenadmin;

    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
    }
    public static final long DateEXP = 230082253;

   
    /*   @PostMapping("/login")
    public TokenAdmin login(@RequestBody Admin admin) throws Exception {
        Admin d = null;
        d = adminService.login(admin.getEmail(), admin.getMotdepasse());
        TokenAdmin t = new TokenAdmin();
        System.out.println(" amind = " + d);
        if (d != null) {
            t.setUtilisateurid(d.getId());
            return this.testToken(t);
        } else {
            throw new Exception("Incorrecte !!");
        }
    }*/
    @GetMapping("/produit")
    public List<Produit> produit() {
        return produit.listeProduit();        
    }

    
    

   
}
