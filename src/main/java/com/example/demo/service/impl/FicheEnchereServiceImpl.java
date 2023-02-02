/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.model.FicheEchere;
import com.example.demo.repository.FicheEchereRepository;
import com.example.demo.service.FicheEnchereService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */

@Service

public class FicheEnchereServiceImpl implements FicheEnchereService {

    @Autowired
    FicheEchereRepository ficheenchererepository;
    
    @Override
    public FicheEchere save(FicheEchere ficheenchere) {
        return ficheenchererepository.save(ficheenchere);
    }

    @Override
    public FicheEchere findLastEnchere(Integer idenchere) {
        return ficheenchererepository.findLast(idenchere);
    }
    @Override
    public List<FicheEchere> getDetails (Integer idenchere){
        return ficheenchererepository.getFicheEchereByIdUtilisateur(idenchere);
    }

    @Override
    public void updateEtatEnchere(int idenchere) {
        ficheenchererepository.updateEtatEnchere(idenchere);
    }

    @Override
    public List<FicheEchere> getDetailsFiche(Integer idenchere) {
       return ficheenchererepository.getDetailsFiche(idenchere);
    }
    
}
