package com.apiVoiture.apiVoiture.dao;

import com.apiVoiture.apiVoiture.model.Voiture;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoitureDaoImpl implements VoitureDao {
    public static List<Voiture>voitures=new ArrayList<>();
    static {
        voitures.add(new Voiture(1, new String("Twingo"), 8500, new String("Renault"), 2012));
        voitures.add(new Voiture(2, new String("Clio"), 12000, new String("Renault"), 2015));
        voitures.add(new Voiture(3, new String("A4"), 20000, new String("Audi"), 2018));
        voitures.add(new Voiture(4, new String("308"), 15550, new String("Peugeot"), 2017));
        voitures.add(new Voiture(5, new String("C4"), 13200, new String("Citroen"), 2014));
        voitures.add(new Voiture(6, new String("Vectra"), 900, new String("Opel"), 1996));
        voitures.add(new Voiture(7, new String("Mustang"), 32000, new String("Ford0"), 2018));
    }

    @Override
    public List<Voiture> findAll() {
        return voitures;
    }

    @Override
    public Voiture findById(int id) {
        for (Voiture voiture :voitures) {
            if (voiture.getId() == id) {
            return voiture;
            }
        }
        return null;
    }

    @Override
    public Voiture save(Voiture voiture) {
        voitures.add(voiture);
        return voiture;
    }

    @Override
    public Voiture delete(int id) {
        for (Voiture voiture :voitures) {
            if (voiture.getId() == id) {
                voitures.remove(voiture);
                return voiture;
            }
        }
        return null;
    }

    @Override
    public Voiture update(int id, Voiture voitureModif) {
        for (Voiture voiture :voitures) {
            if (voiture.getId() == id) {
                voiture.merge(voitureModif);
                return voiture;
            }
        }
        return null;
    }

}
