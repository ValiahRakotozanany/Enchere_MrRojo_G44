/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Valiah Karen
 */
@Data
@Entity
@Table(name = "assurancevehicul")
public class AssuranceVehicule {

    @Id
    private int id;
    @Column(name = "vehicule")
    private String vehicule;

    @Column(name = "numero")
    private String numero;

    @Column(name = "date_fin")
    private Date date_fin;

    @Column(name = "date_debut")
    private Date date_debut;

    @Column(name = "montant")
    private double montant;

    @Column(name = "jourmois")
    private int jourMois;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /*
    create or replace view assurancevehicul as (select *,(date_fin- current_date)as jourMois from assuranceVehicule) ;
    */
}
