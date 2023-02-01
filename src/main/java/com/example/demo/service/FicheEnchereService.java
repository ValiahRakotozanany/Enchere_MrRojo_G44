/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.FicheEchere;
import java.util.List;

/**
 *
 * @author Murphy
 */
public interface FicheEnchereService {
    public FicheEchere save (FicheEchere ficheenchere);
    public FicheEchere findLastEnchere (Integer idenchere) ;
    public List<FicheEchere> getDetails (Integer idenchere);
    void updateEtatEnchere(int idenchere);
}
