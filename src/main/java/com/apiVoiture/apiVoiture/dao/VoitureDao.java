package com.apiVoiture.apiVoiture.dao;

import com.apiVoiture.apiVoiture.model.Voiture;

import java.util.List;

public interface VoitureDao {
    public List<Voiture>findAll();
    public Voiture findById(int id);
    public Voiture save(Voiture voiture);
    public Voiture delete(int id);
    public Voiture update(int id, Voiture voiture);
}
