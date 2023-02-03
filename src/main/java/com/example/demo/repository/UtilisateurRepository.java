/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Admin;
import com.example.demo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Murphy
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer>{
    @Query(value="select solde from solde where idutilisateur = :idutilisateur",nativeQuery = true)
    public Double getSolde (@Param(value = "idutilisateur") Integer idutilisateur);
    public Utilisateur findByEmailAndMotdepasse(String email,String motdepasse);
   // @Query(value="Select * from utilisateur where email = :email and password= :mdp",nativeQuery = true)
   // public Utilisateur findByEmailAndMotdepasse (@Param(value = "email")String email,@Param(value = "mdp")String mdp);

}
