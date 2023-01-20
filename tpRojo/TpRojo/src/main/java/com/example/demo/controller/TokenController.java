/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Token;
import com.example.demo.model.Vehicule;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Valiah Karen
 */
@Controller
@RequestMapping("/gestionflotte/token")
public class TokenController {
    
    @Autowired
    TokenService tokenService;
    
    
      @GetMapping("{id}")
/*    public ResponseEntity<Admin> getVehiculeById (@PathVariable(name = "email") String email,@PathVariable(name = "mdp") String mdp) {
        return new ResponseEntity<Admin>(adminService.getAdmin(email,mdp),HttpStatus.OK);
    }
    
    */
    @PostMapping()
    public ResponseEntity<Token> saveToken(@RequestBody int idUtilisateur){
        Token token = new Token();
        return new ResponseEntity<Token>(tokenService.save_token(token.CreerToken(idUtilisateur)),HttpStatus.CREATED);
    }
    
    @PostMapping("tok")
    public void token(String email,String mdp){
       // int id   = this.getVehiculeById(email, mdp).getBody().getId();
        //this.CreerToken(id);        
    }
    
    
}
