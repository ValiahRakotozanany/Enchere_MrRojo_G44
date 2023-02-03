/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.model.Commission;
import com.example.demo.model.Enchere;
import com.example.demo.model.Historique;
import com.example.demo.model.Photo;
import com.example.demo.model.Produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ComissionRepository;
import com.example.demo.repository.EnchereRepository;
import com.example.demo.repository.HistoriqueRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.repository.UtilisateurRepository;
import com.example.demo.service.EnchereService;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Murphy
 */
@Service

public class EnchereServiceImpl implements EnchereService {

    @PersistenceContext
    EntityManager entitymanger;
    
    @Autowired
    EnchereRepository enchereRepository;

    @Autowired
    ProduitRepository produitrepository;

    @Autowired
    PhotoRepository photorepository;

    @Autowired
    UtilisateurRepository utilisateurrepository;

    @Autowired
    CategorieRepository categorierepository;

    @Autowired
    HistoriqueRepository historiquerepository;

    @Autowired
    ComissionRepository comissionRepository;

    @Override
    public Enchere save(Enchere enchere) {
        return enchereRepository.save(enchere);
    }

    @Override
    public List<Enchere> findAll() {
        return enchereRepository.findAll();
    }

    @Override
    public List<Enchere> findByUtilisateur(Integer idutilisateur) {
        return enchereRepository.findByUtilisateur(idutilisateur);
    }

    @Override
    public List<Produit> findByProduit(Integer idproduit) {
        return enchereRepository.findByProduit(idproduit);
    }

    @Override
    public Enchere findById(Integer id) {
        return enchereRepository.findById(id).get();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Enchere save(Produit produit, Enchere enchere, String[] photos) throws Exception {
//        Historique historique = new Historique();
//        Produit pr = produitrepository.save(produit);
//        historique.setProduit(pr);
//        enchere.setProduit(pr);
//        Enchere echr = enchereRepository.save(enchere);
//        historique.setUtilisateur(utilisateurrepository.findById(echr.getUtilisateur()).get());
//        historique.setCategorie(categorierepository.findById(pr.getCategorie()).get());
//        historique.setEnchere(echr);
//        historiquerepository.save(historique);
//        System.out.println("tsy mety mijanona");
//        for (String ph : photos) {
//            Photo photo = new Photo();
//            photo.setIdenchere(echr.getId());
//            photo.setBase64(ph);
//            photorepository.save(photo);
//        }
//        
//        return enchere;
        return null;
        Historique historique = new Historique();
        Produit pr = produitrepository.save(produit);
        historique.setProduit(pr);
        enchere.setProduit(pr.getId());
        Enchere echr = enchereRepository.save(enchere);
        historique.setUtilisateur(utilisateurrepository.findById(echr.getUtilisateur()).get());
        historique.setCategorie(categorierepository.findById(pr.getCategorie()).get());
        historique.setEnchere(echr);
        historiquerepository.save(historique);
        System.out.println("tsy mety mijanona");
        for (String ph : photos) {
            Photo photo = new Photo();
            photo.setIdenchere(echr.getId());
            photo.setBase64(ph);
            photorepository.save(photo);
        }

        return enchere;
    }

    
    public List<Enchere> getEnchereActif (){
        return enchereRepository.getEnchereActif();
    }
    
    @Override
    public List<Enchere> rechercheAvance(Enchere enchere) {
        String sql = " select * from enchere e join produit p on e.idproduit=p.id where 0=0";
        if (enchere.getDatetime() != null) {
            sql += " and datetime="+enchere.getDatetime();
        }
        if (enchere.getPrixminimal() != null) {
            sql += " and prixminimal = "+enchere.getPrixminimal();
        }
        if (enchere.getEtat() != null) {
            sql += "and etat ="+enchere.getEtat();
        }
        if (enchere.getDescription() != null) {
            sql += " and description like '%"+enchere.getDescription()+"%' ";
        }
        if (enchere.getProduit() != null) {
            if (enchere.getProduit().getCategorie() != null) {
                if (enchere.getProduit().getCategorie().getId() != null) {
                    sql += " and idcategorie ="+enchere.getProduit().getCategorie().getId();
                }
            }
        }
        System.out.println("sql == "+sql);
        Query query = entitymanger.createNativeQuery(sql,Enchere.class);
        
        List<Enchere> resultat = (List<Enchere>)query.getResultList();
        return resultat;
    }

    public void updateCommsion(double pourcentage) {
        comissionRepository.updatecomission(pourcentage);
    }

    @Override
    public Commission comission() {
        return comissionRepository.findAll().get(0);
    }

    public void rechercheAvance() {

    }

}
