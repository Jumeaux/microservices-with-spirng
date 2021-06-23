package com.anies.training.membre.service;

import com.anies.training.core.entity.membre.Membre;

import java.util.List;
import java.util.Optional;

public interface MembreService {

    Membre createMembre(Membre membre);

    Membre updateMembre(Membre membre);

    Optional<Membre> getMembre(Long id);

    List<Membre> getAllMembre();

    void deleteMembre(Long id);
}
