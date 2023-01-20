/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.Token;
import com.example.demo.model.Vehicule;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.TokenService;
import com.example.demo.service.VehiculeService;
import java.util.List;
import org.springframework.stereotype.Service;
/**
 *
 * @author hp
 */
@Service
public class TokenServiceImpl implements TokenService{
    TokenRepository tr;
    @Override
    public Token save_token(Token tok) {
        return tr.save(tok);
    }

    
}
