package com.example.demo.controller;

import com.example.demo.model.TokenUtilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.demo.service.CategorieService;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
    
    TokenUtilisateur tokenutilisateur;
    
    @Autowired
    CategorieService categorieservice;

    @GetMapping
    public ResponseEntity liste (@RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        HashMap<String, Object> resultat = new HashMap<>();
        resultat.put("data",categorieservice.listecategorie());
        return new ResponseEntity(resultat, HttpStatus.OK);
    }
    
    

}
