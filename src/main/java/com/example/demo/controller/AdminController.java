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
import com.example.demo.model.Rechargement;
import com.example.demo.model.TokenAdmin;
import com.example.demo.service.AdminService;
import com.example.demo.service.CategorieService;
import com.example.demo.service.EnchereService;
import com.example.demo.service.MouvementService;
import com.example.demo.service.TokenService;
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
@Controller
@CrossOrigin("*")
public class AdminController {

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
    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login/log")
    public TokenAdmin tok(@RequestBody Admin a) throws Exception {
        Admin d = null;
        
        TokenAdmin t = new TokenAdmin();       
            d = adminService.login(a.getEmail(),a.getMotdepasse());            
            if (d != null) {
                t.setUtilisateurid(d.getId());
                t = this.testToken(t);
            } else {
                throw new Exception("Incorrecte !!");
           
        }return t;
    }
    @GetMapping("admin/statistique")
    public void stat() {

}

    
     @GetMapping("/to")
    public void verifierTokenClient(@RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenadmin.verifierTokenClient(token, request);
         System.out.println(" mandeha");
    }

    @PostMapping("/admin/login")
    public String log(HttpServletRequest request, Model model) throws Exception {
        Admin d = null;
        if (request.getParameter("email") != null && request.getParameter("mdp") != null) {
            d = adminService.login(request.getParameter("email"), request.getParameter("mdp"));
            TokenAdmin t = new TokenAdmin();
            if (d != null) {
                t.setUtilisateurid(d.getId());
                this.testToken(t);
            } else {
                throw new Exception("Incorrecte !!");
            }
        } else {
            int idadmin = Integer.parseInt(request.getParameter("idadmin"));
            int iduser = Integer.parseInt(request.getParameter("iduser"));
            if (Integer.parseInt(request.getParameter("re")) == 1) {
                verifierToken(idadmin, request);
                mouvementservice.validationRechargement(iduser, 1);
            } else if (Integer.parseInt(request.getParameter("re")) == 2) {
                verifierToken(idadmin, request);
                mouvementservice.validationRechargement(iduser, 2);
            }
            d = adminService.adminbyid(idadmin);
        }
        List<Rechargement> rechargement = mouvementservice.demanderechargement();
        model.addAttribute("rechargement", rechargement);
        model.addAttribute("admin", d);
        return "admin/login";

    }

//    @GetMapping("/token/{idU}")
//    public String CreerToken(@PathVariable(name = "idU") String idU) {
//        int idUtilisateur = Integer.parseInt(idU);
//        Token token = new Token();
//        return token.CreerToken(idUtilisateur);
//    }
    @PostMapping("/admin/categorie")
    public String categorie(HttpServletRequest request, Model model) throws Exception {
        int idadmin = Integer.parseInt(request.getParameter("idadmin"));
        verifierToken(idadmin, request);
        if (request.getParameter("nom") != null) {
            Categorie c = new Categorie();
            c.setNom(request.getParameter("nom"));
            categorieservice.saveCategorie(c);
        }
        if (request.getParameter("comission") != null) {
            System.out.println(request.getParameter("comission") + " comm");
            enchereservice.updateCommsion(Double.parseDouble(request.getParameter("comission")));
        }
        Commission comission = new Commission();
        comission = enchereservice.comission();
        model.addAttribute("comission", comission);
        List<Categorie> categorie = categorieservice.listecategorie();
        model.addAttribute("categorie", categorie);
        model.addAttribute("idadmin", idadmin);
        return "admin/categorie";
    }

    public TokenAdmin testToken(TokenAdmin tok) {
        TokenAdmin token = new TokenAdmin();
        System.out.println(" idddd = " + tok.getToken());
        token.setUtilisateurid(tok.getUtilisateurid());
        LocalDateTime localDate = LocalDateTime.now();
        Timestamp now = Timestamp.valueOf(localDate);
        token = tokService.findByUtilisateurid(tok.getUtilisateurid());
        System.out.println(" token = " + token);
        if (token == null) {
            now = tokService.addDateTime(now, null, null, null, null, 5, null);
            token = new TokenAdmin();
            //System.out.println(" toke "+t.CreerToken(1));
            Timestamp dt = new Timestamp(System.currentTimeMillis() + DateEXP);
            token.setDateExpiration(dt);
            token.setUtilisateurid(tok.getUtilisateurid());
            token.setToken(token.CreerToken());
            tokService.saveToken(token);
            return token;
        } else {
            Timestamp dt = new Timestamp(System.currentTimeMillis() + DateEXP);
            now = tokService.addDateTime(now, null, null, null, null, 5, null);
            System.out.println(" now = " + now);
            token.setToken(token.CreerToken());
            token.setDateExpiration(dt);
            tokService.saveToken(token);
            return token;
        }
        
    }

    @GetMapping("/verifier/{idadmin}")
    public void verifier(HttpServletRequest request, @PathVariable(name = "idadmin") int idadmin) throws Exception {
        verifierToken(idadmin, request);
    }

    public void verifierToken(int idadmin, HttpServletRequest request) throws Exception {
        TokenAdmin tokadmin = tokService.findByUtilisateurid(idadmin);
        //DateTime.now()
        System.out.println(" date now = " + Date.from(Instant.now()));
        System.out.println(" date expiration = " + tokadmin.getDateExpiration());
        if (tokadmin.getDateExpiration().after(Date.from(Instant.now()))) {
            TokenAdmin.verifierToken(tokadmin.getToken(), request);
        } else {
            TokenAdmin.verifierToken(null, request);
        }
    }

    @PostMapping("/validercompte/{iduser}/{idadmin}")
    public void validerRechargement(HttpServletRequest request, @PathVariable(name = "iduser") int iduser, @PathVariable(name = "idadmin") int idadmin) throws Exception {
        verifierToken(idadmin, request);
        mouvementservice.validationRechargement(iduser, 1);
    }

    @GetMapping("/enchereplusenvie")
    public List<Chiffreenchere> enchereplusenvie(){
        return stat.enchereplusenvie();
    }
    
  
    @PostMapping("/annuler/{iduser}/{idadmin}")
    public void annulationRechargement(HttpServletRequest request, @PathVariable(name = "iduser") int iduser, @PathVariable(name = "idadmin") int idadmin) throws Exception {
        verifierToken(idadmin, request);
        mouvementservice.validationRechargement(iduser, 2);
    }

}
