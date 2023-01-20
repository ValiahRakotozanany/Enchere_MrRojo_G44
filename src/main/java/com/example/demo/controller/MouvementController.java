/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Mouvement;
import com.example.demo.model.TokenUtilisateur;
import com.example.demo.service.MouvementService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/Echere/Mouvement")
@CrossOrigin("*")
public class MouvementController {

    @Autowired
    MouvementService mouvementservice;

    TokenUtilisateur tokenutilisateur;

    @PostMapping
    public ResponseEntity<Mouvement> saveMouvement(@RequestBody Mouvement mouvement, @RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        return new ResponseEntity<Mouvement>(mouvementservice.insertionMouvement(mouvement), HttpStatus.CREATED);
    }
}
