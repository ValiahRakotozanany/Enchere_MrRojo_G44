/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.TokenAdmin;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.TokenService;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Valiah Karen
 */
@Service

public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenRepository tok;

    @Override
    public TokenAdmin findByUtilisateurid(int token) {
        return tok.tokenadmin(token);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void updateTokenAndExpiration(String token, Timestamp expiration, int id) {
       /* String sql = "update Token set token=? and expiration=? where utilisateurid=?";
        jdbcTemplate.update(sql, token, expiration, id);
        System.out.println("OK INSERTION TELECHARGEMENT");*/
       tok.updateToken(token, expiration, id);
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

    @Override
    public TokenAdmin saveToken(TokenAdmin token) {
        return tok.save(token);
    }
    
}
