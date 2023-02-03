/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Murphy
 */

@Data
@Entity
@Table(name = "enchere")
public class Enchere {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "description")
    String description;
    @Column(name = "prixminimal")
    Double prixminimal;
    @Column(name = "durree")
    Time durree;
    @Column(name = "datetime")
    Timestamp datetime;
    @ManyToOne
    @JoinColumn(name = "idutilisateur",referencedColumnName = "id")
    Utilisateur utilisateur ;
    @ManyToOne
    @JoinColumn(name = "idproduit",referencedColumnName = "id")
    Produit produit;
    @Column(name = "etat")
    Integer etat;
    @OneToMany(mappedBy = "idenchere")
    public List<Photo> photos;
    @OneToMany(mappedBy = "idenchere")
    public List<FicheEchere> ficheenchere;


    public Timestamp getDateLimit () {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getDatetime().getTime());
        cal.add(Calendar.HOUR,getDurree().getHours());
        cal.add(Calendar.MINUTE, getDurree().getMinutes());
        cal.add(Calendar.SECOND, getDurree().getSeconds());
        return new Timestamp(cal.getTimeInMillis());
    }
    
}
