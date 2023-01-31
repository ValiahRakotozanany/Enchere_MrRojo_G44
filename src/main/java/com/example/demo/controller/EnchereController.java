/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Chiffreenchere;
import com.example.demo.model.Enchere;
import com.example.demo.model.Photo;
import com.example.demo.model.Produit;
import com.example.demo.service.EnchereService;
import com.example.demo.service.PhotoService;
import com.example.demo.service.ProduitService;
import java.util.HashMap;
import com.example.demo.service.impl.StatistiqueServiceImpl;
import java.util.List;
import org.apache.naming.factory.TransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Error;
import com.example.demo.model.TokenUtilisateur;
import com.example.demo.repository.UtilisateurRepository;
import com.example.demo.service.UtilisateurService;
import javax.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Murphy
 */

@RestController
@RequestMapping("/Enchere/Enchere")
@CrossOrigin
public class EnchereController {
    @Data
    public static class MyRequestBody {
        Produit produit;
        Enchere enchere;
        String[] photos;
    }
    TokenUtilisateur tokenutilisateur;

    
     @Autowired
        StatistiqueServiceImpl stat;
   
    @Autowired
    EnchereService enchereservice;

    @Autowired
    UtilisateurService utilisateurService;
    
    @PostMapping
//    public ResponseEntity save (@RequestBody Object[] objects){
    public ResponseEntity save(@RequestBody MyRequestBody object, @RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        HashMap<String, Object> resultat = new HashMap<>();
        try {
//            resultat.put("data",enchereservice.save((Produit)objects[0],(Enchere)objects[1],(String[])objects[2]));
            resultat.put("data", enchereservice.save(object.getProduit(), object.getEnchere(), object.getPhotos()));
        } catch (Exception e) {
            Error error = new Error();
            error.setCode("404");                        
            resultat.put("error",error);
            error.setMessage("insertion non valide");
            
        }
        return new ResponseEntity(resultat, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity liste () throws Exception {
        HashMap<String,Object> resultat = new HashMap<>();
        List<Enchere> list = enchereservice.getEnchereActif();
        resultat.put("data",list);
        return new ResponseEntity(resultat,HttpStatus.OK);
    }   
    
    @GetMapping("/recherche")
    public ResponseEntity rechercheAvancee (@RequestBody Enchere enchere,@RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        HashMap<String,Object> resultat = new HashMap<>();
        List<Enchere> list = enchereservice.rechercheAvance(enchere);
        resultat.put("data",list);
        return new ResponseEntity(resultat,HttpStatus.OK);
    }
    
    

    public ResponseEntity liste(@RequestBody Enchere enchere, @RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        HashMap<String, Object> resultat = new HashMap<>();
        List<Enchere> list = enchereservice.rechercheAvance(enchere);
        resultat.put("data", list);
        return new ResponseEntity(resultat, HttpStatus.OK);
    }


    
    
    @GetMapping("/chiffremaxenchere")
    public List<Chiffreenchere> chiffremaxenchere(){
        return stat.chiffremaxenchere();
    }
    
    @GetMapping("/enchereplusenvie")
    public List<Chiffreenchere> enchereplusenvie(){
        return stat.enchereplusenvie();
    }
}
