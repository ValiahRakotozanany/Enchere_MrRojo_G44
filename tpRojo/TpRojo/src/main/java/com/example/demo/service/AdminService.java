/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Admin;

/**
 *
 * @author Valiah Karen
 */
public interface AdminService {
    Admin getAdmin (String email,String mdp);
    
    
}
