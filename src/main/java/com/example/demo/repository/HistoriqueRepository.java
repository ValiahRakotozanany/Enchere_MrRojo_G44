/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Historique;
import com.example.demo.model.Utilisateur;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Murphy
 */
public interface HistoriqueRepository extends MongoRepository<Historique,String> {
    public List<Historique> findByUtilisateur(Utilisateur utilisateur);
}
