/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.CategorieStat;
import com.example.demo.model.Enchere;
import com.example.demo.model.FicheEchere;
import com.example.demo.service.EnchereService;
import com.example.demo.service.FicheEnchereService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Error;
import com.example.demo.service.UtilisateurService;

import com.example.demo.model.TokenUtilisateur;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import com.example.demo.service.CategorieService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Murphy
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/Enchere")

public class FicheEnchereController {

    @Autowired
    EnchereService enchereService;
    @Autowired
    FicheEnchereService ficheEnchereService;
    @Autowired
    UtilisateurService utilisateurservice;

    TokenUtilisateur tokenutilisateur;

    @GetMapping("{id}/details")
    public ResponseEntity getDetails(@PathVariable("id") Integer id, @RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        HashMap<String, Object> resultat = new HashMap<>();
        resultat.put("data", ficheEnchereService.getDetailsFiche(id));
        return new ResponseEntity(resultat, HttpStatus.OK);
    }

    
    @GetMapping("{id}/detailsenchere")
    public ResponseEntity getDetailsenchere(@PathVariable("id") Integer id, @RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        HashMap<String, Object> resultat = new HashMap<>();
        resultat.put("data", ficheEnchereService.findByEncher(id));
        return new ResponseEntity(resultat, HttpStatus.OK);
    }

    @Autowired
    CategorieService categorieservice;

    @PostMapping("/rencherir")
    public ResponseEntity saveBase(@RequestBody FicheEchere ficheenchere, @RequestHeader String token, HttpServletRequest request) throws Exception {
        System.out.println("tokk = " + token);
        System.out.println("utilisateur  = " + ficheenchere.getUtilisateur().getId());
        tokenutilisateur.verifierTokenClient(token, request);
        Enchere enchere = enchereService.findById(ficheenchere.getIdenchere());
        FicheEchere lastenchere = ficheEnchereService.findLastEnchere(ficheenchere.getIdenchere());
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        Error error = new Error();
        HashMap<String, Object> resultat = new HashMap<>();
        error.setCode("404");
        Double solde = utilisateurservice.getSoldeBase(ficheenchere.getUtilisateur().getId());
        if(ficheenchere.getUtilisateur().getId().equals(enchere.getUtilisateur().getId())) {
            error.setMessage(" vous ne pouvez pas participer a votre propre enchere ");
            resultat.put("error", error);
            System.out.println("vous ne pouvez pas participer a votre propre enchere ");
            return new ResponseEntity(resultat, HttpStatus.OK);
        }
        if (ficheenchere.getMontant() > solde) {
            error.setMessage("solde insuffisant ");
            resultat.put("error", error);
            System.out.println("solde insuffisant");
            return new ResponseEntity(resultat, HttpStatus.OK);
        }
        if (lastenchere != null) {
            if (ficheenchere.getMontant() <= lastenchere.getMontant()) {
                error.setMessage("cette montant est deja depass??");
                resultat.put("error", error);
                System.out.println("cette montant est deja depass??");
                return new ResponseEntity(resultat, HttpStatus.OK);
            }
        }
        if (ficheenchere.getMontant() <= enchere.getPrixminimal()) {
            error.setMessage("cette enchere debut a" + enchere.getPrixminimal());
            resultat.put("error", error);
            System.out.println("cette enchere debut a" + enchere.getPrixminimal());
            return new ResponseEntity(resultat, HttpStatus.OK);
        }
        if (lastenchere != null) {
            lastenchere.setEtat(0);
            ficheEnchereService.save(lastenchere);
        }
        ficheenchere.setDatetime(now);
        ficheenchere.setEtat(1);
        FicheEchere fich = ficheEnchereService.save(ficheenchere);
        resultat.put("data", fich);
        return new ResponseEntity(resultat, HttpStatus.OK);
    }

//    @PostMapping("/rencherir")
//    public ResponseEntity save(@RequestBody FicheEchere ficheenchere, @RequestHeader String token, HttpServletRequest request) throws Exception {
//        System.out.println("tokk = " + token);
//        System.out.println("utilisateur  = " + ficheenchere.getUtilisateur().getId());
//        tokenutilisateur.verifierTokenClient(token, request);
//        Enchere enchere = enchereService.findById(ficheenchere.getIdenchere());
//        FicheEchere lastenchere = ficheEnchereService.findLastEnchere(ficheenchere.getIdenchere());
//        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
//        Error error = new Error();
//        HashMap<String, Object> resultat = new HashMap<>();
//        error.setCode("404");
//        System.out.println(enchere.getDatetime());
//        System.out.println(enchere.getDateLimit());
//        if (enchere.getId() == ficheenchere.getUtilisateur().getId()) {
//            error.setMessage("Vous ne pouvez pas participer ?? votre propre enchere");
//            resultat.put("error", error);
//            System.out.println("solde insuffisant");
//            return new ResponseEntity(resultat, HttpStatus.OK);
//        }
//        if (utilisateurservice.getsolde(ficheenchere.getUtilisateur().getId()) < ficheenchere.getMontant()) {
//            System.out.println("solde = >  " + utilisateurservice.getsolde(ficheenchere.getUtilisateur().getId()));
//            error.setMessage("solde insuffisant");
//            resultat.put("error", error);
//            System.out.println("solde insuffisant");
//            return new ResponseEntity(resultat, HttpStatus.OK);
//        }
//        if (ficheenchere.getMontant() <= lastenchere.getMontant() || ficheenchere.getMontant() < enchere.getPrixminimal()) {
//            error.setMessage("montant trop petit");
//            resultat.put("error", error);
//            System.out.println("montant farany = " + lastenchere.getMontant());
//            System.out.println("montant trop petit");
//            return new ResponseEntity(resultat, HttpStatus.OK);
//        } else if (now.after(enchere.getDateLimit())) {
//            error.setMessage("date limit atteint");
//            resultat.put("error", error);
//            System.out.println("date limit atteint");
//            return new ResponseEntity(resultat, HttpStatus.OK);
//        }
//        ficheEnchereService.updateEtatEnchere(enchere.getId());
//        ficheenchere.setDatetime(now);
//        ficheenchere.setEtat(1);
//        lastenchere.setEtat(0);
//        ficheenchere.setIdenchere(enchere.getId());
//        System.out.println("mety ve ?");
//        ficheEnchereService.save(lastenchere);
//        resultat.put("data", ficheEnchereService.save(ficheenchere));
//        return new ResponseEntity(resultat, HttpStatus.OK);
//    }

    @GetMapping("/categoriemax")
    public List<CategorieStat> categoriemax() {
        return categorieservice.listeCategorieMax();
    }

}
