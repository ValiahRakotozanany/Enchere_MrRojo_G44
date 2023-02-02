/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Murphy
 */
@Data
@Entity
@Table(name = "ficheechere")
public class FicheEchere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "montant")
    Double montant;
    @Column(name = "datetime")
    Timestamp datetime;
    @ManyToOne
    @JoinColumn(name = "idutilisateur", referencedColumnName = "id")
    Utilisateur utilisateur;
    
    @ManyToOne
    @JoinColumn(name = "idenchere", referencedColumnName = "id")
    Enchere enchere;
    @Column(name = "etat")
    Integer etat;

}
