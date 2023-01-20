/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepository;
    
    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin login(String email, String mdp) {
        return adminRepository.findByEmailAndMotdepasse(email,mdp);
    }
    
}
