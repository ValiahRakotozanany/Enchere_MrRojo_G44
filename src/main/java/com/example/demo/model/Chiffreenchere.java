/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Murphy
 */
@Data
@Entity
@Table(name = "chiffrerapporteenchere")
public class Chiffreenchere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idenchere")
    Integer id;

    @Column(name = "nom")
    String nom;

    @Column(name = "prenom")
    String prenom;

    @Column(name = "produit")
    String produit;

    @Column(name = "description")
    String description;

    @Column(name="prixminimal")
    double prixminimal;
    
    @Column(name = "idutilisateur")
    int idutilisateur;

    @Column(name = "chiffre")
    double chiffre;
    
    @Column(name = "idproduit")
    int idproduit;
    
    @Column(name = "nombreuser")
    int nombreuser;

}
