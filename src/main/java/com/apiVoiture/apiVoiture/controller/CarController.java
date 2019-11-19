package com.apiVoiture.apiVoiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.apiVoiture.apiVoiture.model.Voiture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.apiVoiture.apiVoiture.dao.VoitureDao;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private  VoitureDao voitureDao;

    @GetMapping(value = "/Voitures")
    public List<Voiture> listeVoiture() {
        return voitureDao.findAll();
    }

    @GetMapping(value = "/Voitures/{id}")
    public Voiture trouverUneVoiture(@PathVariable int id) {
        return voitureDao.findById(id);
    }

    @PostMapping(value = "/Voitures")
    public ResponseEntity<Void> ajouterVoiture(@RequestBody Voiture voiture) {
       Voiture voitureAdded = voitureDao.save(voiture);

       if(voitureAdded == null) {
           return  ResponseEntity.noContent().build();
       }

       URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(voitureAdded.getId())
               .toUri();

       return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/Voitures/{id}")
    public Voiture supprimerVoiture(@PathVariable int id){
        return voitureDao.delete(id);
    }

    @PutMapping(value = "/Voitures/{id}")
    public Voiture mettreAJourVoiture(@PathVariable int id, @RequestBody Voiture voiture){
        return voitureDao.update(id, voiture);
    }
}
