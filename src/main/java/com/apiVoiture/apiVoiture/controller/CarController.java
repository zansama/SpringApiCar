package com.apiVoiture.apiVoiture.controller;

import com.apiVoiture.apiVoiture.dao.VoitureRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import com.apiVoiture.apiVoiture.model.Voiture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.apiVoiture.apiVoiture.dao.VoitureDao;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private VoitureRepository voitureRepository;

    @GetMapping(value = "/Voitures")
    public List<Voiture> listeVoiture() {
        Iterable<Voiture> iteVoiture = voitureRepository.findAll();
        List<Voiture> voitures = Lists.newArrayList(iteVoiture);
        return voitures;
    }

    @GetMapping(value = "/Voitures/{id}")
    public Voiture trouverUneVoiture(@PathVariable int id, HttpServletResponse response) {
        Voiture voiture = null;
        try {
             voiture = voitureRepository.findById(id).orElseThrow(()->new Exception());
        } catch (Exception e) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }

        return voiture;
    }

    @PostMapping(value = "/Voitures")
    public ResponseEntity<Void> ajouterVoiture(@RequestBody Voiture voiture) {
       Voiture voitureAdded = voitureRepository.save(voiture);

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
    public void supprimerVoiture(@PathVariable int id){
         voitureRepository.deleteById(id);
    }

    @PutMapping(value = "/Voitures/{id}")
    public Voiture mettreAJourVoiture(@PathVariable int id, @RequestBody Voiture voiture, HttpServletResponse response){
        Voiture modifvoiture = null;
        try {
            modifvoiture = voitureRepository.findById(id).orElseThrow(()->new Exception());
            modifvoiture.merge(voiture);
            voitureRepository.save(modifvoiture);
        } catch (Exception e) {
            response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        }
        return modifvoiture;
    }
}
