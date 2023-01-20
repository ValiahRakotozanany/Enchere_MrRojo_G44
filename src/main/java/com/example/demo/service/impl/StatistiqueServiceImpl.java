/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.Admin;
import com.example.demo.model.CategorieStat;
import com.example.demo.model.Chiffreenchere;
import com.example.demo.model.PersonneparEnchere;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CategorieStatRepository;
import com.example.demo.repository.ChiffreenchereRepository;
import com.example.demo.repository.PersonneparEnchereRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.StatistiqueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */
@Service
public class StatistiqueServiceImpl implements StatistiqueService {

    @Autowired
    CategorieStatRepository categorie;
    @Autowired
    ChiffreenchereRepository chiffreenchere;

    @Autowired
    PersonneparEnchereRepository personneparenchere;

    @Override
    public List<CategorieStat> categoriedumois(int mois) {
        return categorie.categorieDuMois(mois);
    }

    @Override
    public List<PersonneparEnchere> nombrepersonneparenchere() {
        return personneparenchere.nombrepersonneparEnchere();
    }

    @Override
    public List<Chiffreenchere> enchereplusenvie() {
        return chiffreenchere.enchereplusenvie();
    }

    @Override
    public List<Chiffreenchere> chiffremaxenchere() {
        return chiffreenchere.chiffremaxenchere();
    }

}
