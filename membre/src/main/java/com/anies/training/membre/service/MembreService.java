package com.anies.training.membre.service;

import com.anies.training.core.entity.membre.Membre;
import reactor.core.publisher.ParallelFlux;

import java.util.List;
import java.util.Optional;

public interface MembreService {

    Membre createMembre(Membre membre);

    Membre updateMembre(Membre membre);

    Membre getMembre(Long id);

    ParallelFlux<Membre> getAllMembre();

    void deleteMembre(Long id);
}
