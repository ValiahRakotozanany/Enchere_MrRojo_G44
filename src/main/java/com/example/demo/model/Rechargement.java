/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.sql.Timestamp;
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
@Table(name = "rechargement")
public class Rechargement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "idutilisateur")
    int idutilisateur;
    
    @Column(name = "nom")
    String nom;

    @Column(name = "prenom")
    String prenom;

    @Column(name = "montant")
    double montant;

    @Column(name = "etat")
    int etat;

    @Column(name = "email")
    String email;

    @Column(name = "datetime")
    Timestamp datetime;

}
