/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import java.sql.Time;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Murphy
 */

@Data
@Document("historique")
public class Historique {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    @Column(name = "utilisateur")
    Utilisateur utilisateur;
    @Column(name = "enchere")
    Enchere enchere;
    @Column(name = "produit")
    Produit produit;
    @Column(name = "categorie")
    Categorie categorie;
//    @Column(name = "idutilisateur")
//    Integer idutilisateur;
//    @Column(name = "nom")
//    String nom;
//    @Column(name = "prenom")
//    String prenom;
//    @Column(name = "email")
//    String email;
//    @Column(name = "motdepasse")
//    String motdepasse;
//    @Column(name = "idenchere")
//    Integer idenchere;
//    @Column(name = "description")
//    String description;
//    @Column(name = "prixminimal")
//    Double prixminimal;
//    @Column(name = "durree")
//    Time durree;
//    @Column(name = "datetime")
//    Timestamp datetime;
//    @Column(name = "etat")
//    Integer etat;
//    @Column(name = "idproduit")
//    Integer idproduit;
//    @Column(name = "nomproduit")
//    String nomproduit;
//    @Column(name = "idcategorie")
//    Integer idcategorie;
//    @Column(name = "nomcategorie")
//    String nomcategorie;
    
}
