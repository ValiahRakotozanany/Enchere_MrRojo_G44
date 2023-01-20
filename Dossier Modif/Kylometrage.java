/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.sql.Date;
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
@Table(name = "kylometrage")
public class Kylometrage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
//    
//    @ManyToOne
//    @JoinColumn(name = "id_vehicule",referencedColumnName = "id")
//    Vehicule vehicule;
//    
     @Column(name = "id_vehicule")
    int id_vehicule;
    
    @Column(name = "dates")
    Date dates;
    
    @Column(name = "kmdebut")
    Double kmdebut;
    
    @Column(name = "kmfin")
    Double kmfin;
    
}
