/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Admin;

/**
 *
 * @author Murphy
 */
public interface AdminService {
    public Admin saveAdmin (Admin admin);
    public Admin login (String email,String mdp);
}
