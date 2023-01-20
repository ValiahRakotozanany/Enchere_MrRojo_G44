/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Admin;
import com.example.demo.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hp
 */
public interface TokenRepository extends JpaRepository<Admin, Integer>{

    public Token save(Token tok);
    
}
