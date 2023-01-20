/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.CategorieStat;
import com.example.demo.model.Chiffreenchere;
import com.example.demo.model.PersonneparEnchere;
import java.util.List;

/**
 *
 * @author Murphy
 */

public interface StatistiqueService {
   List<CategorieStat> categoriedumois(int mois);
   List<PersonneparEnchere> nombrepersonneparenchere();
   List<Chiffreenchere> enchereplusenvie();
   List<Chiffreenchere> chiffremaxenchere();
}
