/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.TokenAdmin;
import com.example.demo.model.TokenUtilisateur;
import com.example.demo.repository.TokenUtilisateurRepository;
import com.example.demo.service.TokenUtilisateurService;
import java.sql.Timestamp;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class TokenUtilisateurServiceImpl implements TokenUtilisateurService{
    @Autowired
    TokenUtilisateurRepository tok;
    

    @Override
    public TokenUtilisateur findByidUtilisateur(int utilisateurid) {
        return tok.tokenUtilisateur(utilisateurid);
    }

    @Override
    public void updateTokenAndExpirationUtilisateur(String token, Timestamp expiration, int id) {
        tok.updateTokenUtilisateur(token, expiration, id);
    }

    @Override
    public TokenUtilisateur saveTokenUtilisateur(TokenUtilisateur token) {
        return tok.save(token);
    }

    @Override
    public Timestamp addDateTime(Timestamp tm, Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(tm.getTime());
        if (year != null) cal.add(Calendar.YEAR,year);
        if (month != null )  cal.add(Calendar.MONTH,month);
        if (day != null )  cal.add(Calendar.YEAR,year);
        if (hour != null) cal.add(Calendar.HOUR,hour);
        if (minute != null) cal.add(Calendar.MINUTE,minute);
        if (second != null) cal.add(Calendar.SECOND,second);
        return new Timestamp(cal.getTimeInMillis());
    }
}
