package com.anies.training.adresse.service;



import com.anies.training.core.entity.adresse.Adresse;

import java.util.List;
import java.util.Optional;

public interface AdresseService {

    Adresse createAdresse(Adresse adresse);

    Adresse updateAdresse(Adresse adresse);

    Optional<Adresse> getAdresse(Long id);

    List<Adresse> getAllAdresse();

    void deleteAdresse(Long id);
}
