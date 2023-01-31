/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Enchere;
import com.example.demo.model.Produit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Murphy
 */
public interface EnchereRepository extends JpaRepository<Enchere,Integer> {
    public List<Enchere> findByUtilisateur(Integer idutilisateur);
    public List<Produit> findByProduit(Integer idproduit);
    @Query(value = "select * from enchere e where e.etat = :#{#enchere.etat} and e.prixminimal=:#{#enchere.prixminimal} and  ",nativeQuery = true)
    public List<Enchere> rechercheAvance (@Param(value = "enchere") Enchere enchere);
    @Query(value = "select * from enchere where etat=0 ",nativeQuery = true)
    public List<Enchere> getEnchereActif (); 
}
