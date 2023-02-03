/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Photo;
import com.example.demo.model.TokenUtilisateur;
import com.example.demo.service.PhotoService;
import java.util.HashMap;
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
 * @author Murphy
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/Enchere/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    TokenUtilisateur tokenutilisateur;

    @PostMapping
    public ResponseEntity save(@RequestBody Photo photo, HttpServletRequest request) throws Exception {
        //tokenutilisateur.verifierTokenClient(token, request);
        System.out.println(" mandeee");
        HashMap<String, Object> resultat = new HashMap<>();

        try {

            Photo p = photoService.save(photo);
            resultat.put("data", p);
            System.out.println(" mandeee be");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(resultat, HttpStatus.CREATED);

    }

}
