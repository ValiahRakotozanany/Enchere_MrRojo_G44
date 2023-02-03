/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Enchere;
import com.example.demo.model.Produit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Murphy
 */

@Repository
public interface EnchereRepository extends JpaRepository<Enchere, Integer> {


    @Query(value = "select * from enchere where idutilisateur = :id ", nativeQuery = true)
    public List<Enchere> findByUtilisateur(@Param(value = "id") Integer idutilisateur);

    public List<Produit> findByProduit(Integer idproduit);

    // @Query(value = "select * from enchere e where e.etat = :#{#enchere.etat} and
    // e.prixminimal=:#{#enchere.prixminimal} and e.description like
    // '%:#{#enchere.description}%'",nativeQuery = true)
    // public List<Enchere> rechercheAvance (@Param(value = "enchere") Enchere
    // enchere);
    @Query(value = "select * from enchere where etat=0 ", nativeQuery = true)
    public List<Enchere> getEnchereActif();

    // default List<Produit> rechercheAvancee(Enchere enchere) {
        
        













    //     // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    //     CriteriaQuery<User> query = builder.createQuery(User.class);
    //     Root<User> root = query.from(User.class);

    //     List<Predicate> predicates = new ArrayList<>();
    //     if (username != null) {
    //         predicates.add(builder.equal(root.get("username"), username));
    //     }
    //     if (firstName != null) {
    //         predicates.add(builder.equal(root.get("firstName"), firstName));
    //     }
    //     if (lastName != null) {
    //         predicates.add(builder.equal(root.get("lastName"), lastName));
    //     }

    //     query.where(predicates.toArray(new Predicate[0]));

    //     return entityManager.createQuery(query).getResultList();
    //     return null;
    // }

}
