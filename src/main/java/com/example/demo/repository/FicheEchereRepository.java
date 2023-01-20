/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.FicheEchere;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Murphy
 */
public interface FicheEchereRepository extends JpaRepository<FicheEchere,Integer>{
    @Query(value="select * from ficheechere where idenchere = :idenchere  order by datetime desc  limit 1",nativeQuery = true)
    public FicheEchere findLast(@Param(value = "idenchere")Integer idenchere);
    @Query(value="select * from ficheechere where idutilisateur = :idutilisateur and etat=1",nativeQuery = true)
    public List<FicheEchere> getFicheEchereByIdUtilisateur(@Param(value = "idutilisateur")Integer id);
    public List<FicheEchere> findByEnchere(Integer idenchere);
}
