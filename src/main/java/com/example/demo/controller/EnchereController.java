/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Chiffreenchere;
import com.example.demo.model.Enchere;
import com.example.demo.model.Photo;
import com.example.demo.model.Produit;
import com.example.demo.service.EnchereService;
import com.example.demo.service.PhotoService;
import com.example.demo.service.ProduitService;
import java.util.HashMap;
import com.example.demo.service.impl.StatistiqueServiceImpl;
import java.util.List;
import org.apache.naming.factory.TransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Error;
import com.example.demo.model.TokenUtilisateur;
import com.example.demo.repository.UtilisateurRepository;
import com.example.demo.service.UtilisateurService;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Murphy
 */
@RestController
@RequestMapping("/Enchere/Enchere")
@CrossOrigin
public class EnchereController {

    private String dDebut;

    @Data
    public static class MyRequestBody {

        Produit produit;
        Enchere enchere;
        String[] photos;
    }
    TokenUtilisateur tokenutilisateur;

    @Autowired
    StatistiqueServiceImpl stat;

    @Autowired
    EnchereService enchereservice;

    @Autowired
    UtilisateurService utilisateurService;

    @PostMapping
//    public ResponseEntity save (@RequestBody Object[] objects){
    public ResponseEntity save(@RequestBody MyRequestBody object, @RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        HashMap<String, Object> resultat = new HashMap<>();
        try {
//            resultat.put("data",enchereservice.save((Produit)objects[0],(Enchere)objects[1],(String[])objects[2]));
            object.getEnchere().setDatetime(new Timestamp(System.currentTimeMillis()));
            resultat.put("data", enchereservice.save( object.getEnchere()));
        } catch (Exception e) {
            Error error = new Error();
            error.setCode("404");
            resultat.put("error", error);
            error.setMessage("insertion non valide");

        }
        return new ResponseEntity(resultat, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id, @RequestHeader String token, HttpServletRequest request) throws Exception { 
        tokenutilisateur.verifierTokenClient(token, request);
        return new ResponseEntity(enchereservice.findById(id),HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity liste() throws Exception {
        HashMap<String, Object> resultat = new HashMap<>();
        List<Enchere> list = enchereservice.getEnchereActif();
    }*/
    @GetMapping
    public ResponseEntity liste(HttpServletRequest request) throws Exception {
     //   tokenutilisateur.verifierTokenClient(token, request);
        HashMap<String, Object> resultat = new HashMap<>();
        List<Enchere> list = enchereservice.findAll();
        resultat.put("data", list);
        return new ResponseEntity(resultat, HttpStatus.OK);
    }

    @GetMapping("/recherche")
    public ResponseEntity rechercheAvancee(@RequestBody Enchere enchere, @RequestHeader String token, HttpServletRequest request) throws Exception {
        tokenutilisateur.verifierTokenClient(token, request);
        HashMap<String, Object> resultat = new HashMap<>();
        List<Enchere> list = enchereservice.rechercheAvance(enchere);
        resultat.put("data", list);
        return new ResponseEntity(resultat, HttpStatus.OK);
    }

//    public ResponseEntity liste(@RequestBody Enchere enchere, @RequestHeader String token, HttpServletRequest request) throws Exception {
//        tokenutilisateur.verifierTokenClient(token, request);
//        HashMap<String, Object> resultat = new HashMap<>();
//        List<Enchere> list = enchereservice.rechercheAvance(enchere);
//        resultat.put("data", list);
//        return new ResponseEntity(resultat, HttpStatus.OK);
//    }

    @GetMapping("/chiffremaxenchere")
    public List<Chiffreenchere> chiffremaxenchere() {
        return stat.chiffremaxenchere();
    }

    @GetMapping("/enchereplusenvie")
    public List<Chiffreenchere> enchereplusenvie() {
        return stat.enchereplusenvie();
    }
/*
    public String rechercheAvance(Model model, HttpServletRequest request) {
        String requete = "Select *,c.nom,c.id as idcategorie from enchere e join produit p on p.id = e.idproduit join categorie c on c.id = p.idcategorie where 1=1";
        if (request.getParameter("prixminimal") != null) {
            requete += requete + " and e.prixminimal =" + request.getParameter("prixminimal");
        }
        if (request.getParameter("description") != null) {
            requete += requete + " and e.description like '%" + request.getParameter("description") + "%'";
        }
        if (request.getParameter("categorie") != null) {
            requete += requete + " and c.nom like '%" + request.getParameter("categorie") + "%'";
        }
        if (request.getParameter("idcategorie") != null) {
            requete += requete + " and c.id =" + request.getParameter("idcategorie");
        }
        if (request.getParameter("datetime") != null) {
            String time = request.getParameter("categorie");
            time = time.replace("T", " ") + ":00.0000";
            Timestamp dDebut = Timestamp.valueOf(time);
            Timestamp dFin = new Timestamp(dDebut.getYear(), dDebut.getMonth(), dDebut.getDate(),
                     23, 59, 0, 0);
            requete += requete + " and e.datetime >= '" + dDebut + "' and e.datetime<='" + dFin + "'";
        }
        return requete;
    }
           
*/
}
