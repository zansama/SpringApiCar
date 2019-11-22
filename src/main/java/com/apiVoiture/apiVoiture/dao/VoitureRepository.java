package com.apiVoiture.apiVoiture.dao;

import com.apiVoiture.apiVoiture.model.Voiture;
import org.springframework.data.repository.CrudRepository;

public interface VoitureRepository extends CrudRepository<Voiture, Integer> {
}
