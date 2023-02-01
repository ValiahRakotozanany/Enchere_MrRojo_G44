/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Rechargement;
import com.example.demo.model.TokenUtilisateur;
import com.example.demo.model.Utilisateur;
import com.example.demo.service.EnchereService;
import com.example.demo.service.HistoriqueService;
import com.example.demo.service.TokenUtilisateurService;
import com.example.demo.service.UtilisateurService;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.example.demo.model.Error;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author hp
 */
@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    EnchereService enchereservice;
    
    @Autowired
    TokenUtilisateurService tokService;
    
    @Autowired
    HistoriqueService historiqueservice;

    TokenUtilisateur tokenutilisateur;
    
    @PostMapping("insertion")
    public ResponseEntity<Utilisateur> saveUtilisateur(@RequestBody Utilisateur utilisateur,@RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        return new ResponseEntity<Utilisateur>(utilisateurService.saveUtilisateur(utilisateur), HttpStatus.CREATED);
    }
    
    public static final long DateEXP = 230082253;

    
    @PostMapping()
    public ResponseEntity<Utilisateur> save (@RequestBody Utilisateur utilisateur,@RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        return new ResponseEntity<Utilisateur>(utilisateurService.saveUtilisateur(utilisateur),HttpStatus.CREATED);
    } 
    
    @GetMapping("{id}/enchere")
    public ResponseEntity getenchere (@RequestHeader String token,@PathVariable(name = "id") Integer id,HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);        
        HashMap<String,Object> resultat = new HashMap<>();
        resultat.put("data",enchereservice.findByUtilisateur(id));
        return new ResponseEntity(resultat,HttpStatus.OK);
    }
    
    @GetMapping("{id}/historique")
    public ResponseEntity getHistorique (@PathVariable("id") Integer id,@RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        HashMap<String,Object> resultat = new HashMap<>();
        try{
        resultat.put("data",enchereservice.findByUtilisateur(id));        
        System.out.println(" tsy erreur");
        }
        catch(Exception e){
            Error error = new Error();
            error.setCode("404");
            System.out.println("erreur");
            return new ResponseEntity(resultat.put("error", error),HttpStatus.OK);
        }
        return new ResponseEntity(resultat,HttpStatus.OK);
    }
 
    @PostMapping("/login")
    public TokenUtilisateur login(@RequestBody Utilisateur utilisateur) throws Exception {
        //tokenutilisateur.verifierTokenClient(token, request);
        Utilisateur d = null;
        d = utilisateurService.login(utilisateur.getEmail(), utilisateur.getMotdepasse());
        TokenUtilisateur t = new TokenUtilisateur();
        System.out.println(" amind = " + d);
        if (d != null) {
            t.setUtilisateurid(d.getId());
            return this.testToken(t);
        } else {
            throw new Exception("Incorrecte !!");
        }
    }
    /*
       @PostMapping("/login")
    public TokenUtilisateur login(HttpServletRequest request) throws Exception {
        //tokenutilisateur.verifierTokenClient(token, request);
        Utilisateur d = null;
        String email = request.getParameter("email");
           System.out.println(" email = "+email);
        String password= request.getParameter("motdepasse");
        d = utilisateurService.login(email,password);
        TokenUtilisateur t = new TokenUtilisateur();
        System.out.println(" amind = " + d);
        if (d != null) {
            t.setUtilisateurid(d.getId());
            return this.testToken(t);
        } else {
            throw new Exception("Incorrecte !!");
        }
    }*/


  /*  @PostMapping("/login/{email}/{mdp}")
    public TokenUtilisateur log(@PathVariable(name = "email") String email, @PathVariable(name = "mdp") String mdp) throws Exception {
    //public Utilisateur log(@PathVariable(name = "email") String email, @PathVariable(name = "mdp") String mdp) throws Exception {
        Utilisateur d = null;
        d = utilisateurService.login(email, mdp);
        TokenUtilisateur t = new TokenUtilisateur();
        System.out.println(" amind = " + d);
        if (d != null) {
            t.setUtilisateurid(d.getId());
            return this.testToken(t);
        } else {
            throw new Exception("Incorrecte !!");
        }
        //return d;
    }
*/
//    @GetMapping("/token/{idU}")
//    public String CreerToken(@PathVariable(name = "idU") String idU) {
//        int idUtilisateur = Integer.parseInt(idU);
//        Token token = new Token();
//        return token.CreerToken(idUtilisateur);
//    }
    public TokenUtilisateur testToken(TokenUtilisateur tok) {
        TokenUtilisateur token = new TokenUtilisateur();
        System.out.println(" idddd = " + tok.getToken());
        token.setUtilisateurid(tok.getUtilisateurid());
        LocalDateTime localDate = LocalDateTime.now();
        Timestamp now = Timestamp.valueOf(localDate);
        token =  tokService.findByidUtilisateur(tok.getUtilisateurid());
        System.out.println(" token = " + token);
        if (token == null) {
            now = tokService.addDateTime(now, null, null, null, null, 5, null);
            token = new TokenUtilisateur();
            //System.out.println(" toke "+t.CreerToken(1));
            Timestamp dt = new Timestamp(System.currentTimeMillis() + DateEXP);
            token.setDateExpiration(dt);
            token.setUtilisateurid(tok.getUtilisateurid());
            token.setToken(token.CreerToken());
        }
        else {
            Timestamp dt = new Timestamp(System.currentTimeMillis() + DateEXP);
            now = tokService.addDateTime(now, null, null, null, null, 5, null);
            System.out.println(" now = " + now);
            token.setToken(token.CreerToken());
            token.setDateExpiration(dt);
        }
        return tokService.saveTokenUtilisateur(token);
    }
    
//    @GetMapping("/demanderechargement/{idutilisateur}")
//    List<Rechargement> demanderechargement(HttpServletRequest request, @PathVariable(name = "idutilisateur") int idadmin) throws Exception {
//        verifierToken(idadmin, request);
//        return mouvementservice.demanderechargement();
//    }

    @GetMapping("w")
    public void verifier(HttpServletRequest request, @PathVariable(name = "idutilisateur") int idutilisateur) throws Exception {
        verifierToken(idutilisateur, request);
    }

    public void verifierToken(int idutilisateur, HttpServletRequest request) throws Exception {
        TokenUtilisateur tokutilisateur = tokService.findByidUtilisateur(idutilisateur);
        //DateTime.now()
        System.out.println(" date now = " + Date.from(Instant.now()));
        System.out.println(" date expiration = " + tokutilisateur.getDateExpiration());
        if (tokutilisateur.getDateExpiration().after(Date.from(Instant.now()))) {
            TokenUtilisateur.verifierToken(tokutilisateur.getToken(), request);
        } else {
            TokenUtilisateur.verifierToken("", request);
        }
    }
}
