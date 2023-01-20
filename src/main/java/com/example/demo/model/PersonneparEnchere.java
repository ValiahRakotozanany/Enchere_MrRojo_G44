/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.sql.Time;
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
@Table(name = "nombrepersonneparEnchere")
public class PersonneparEnchere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "nombreuser")
    int nombreuser;

    @Column(name = "produit")
    String produit;

    @Column(name = "description")
    String description;

    @Column(name = "durree")
    Time duree;

    @Column(name = "prixminimal")
    double prixminimal;

    @Column(name = "etat")
    int etat;

    @Column(name = "utilisateurid ")
    int utilisateurid;

    @Column(name = "nom")
    String nom;
    
      @Column(name = "prenom")
    String prenom;
    
      @Column(name = "idproduit")
    int idproduit;
 
}
