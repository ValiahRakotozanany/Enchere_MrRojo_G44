/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.AssuranceVehicule;
import com.example.demo.repository.AssurancevehiculeRepository;
import com.example.demo.service.AssuranceVehiculeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Valiah Karen
 */
@Service
public class AssuranceServiceImpl implements AssuranceVehiculeService {

    @Autowired
    AssurancevehiculeRepository avr;
    
    
    @Override
    public List<AssuranceVehicule> findAll() {
        return avr.findAll();
    }

}
