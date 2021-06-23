package com.anies.training.menage.service;

import com.anies.training.core.entity.menage.Menage;

import java.util.List;
import java.util.Optional;

public interface MenageService {

    Menage createMenage(Menage menage);

    Menage updateMenage(Menage menage);

    Optional<Menage> getMenage(Long id);

    List<Menage> getAllMenage();

    void deleteMenage(Long id);
}
