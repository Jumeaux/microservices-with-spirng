package com.anies.training.adresse.service.impl;

import com.anies.training.adresse.repository.AdresseRepository;
import com.anies.training.adresse.service.AdresseService;
import com.anies.training.core.entity.adresse.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseImpl implements AdresseService {

    @Autowired
    AdresseRepository adresseRepository;

    @Override
    public Adresse createAdresse(Adresse adresse) {
        return  adresseRepository.save(adresse);
    }

    @Override
    public Adresse updateAdresse(Adresse adresse) {

       return adresseRepository.save(adresse);
    }

    @Override
    public Optional<Adresse> getAdresse(Long id) {

        return adresseRepository.findById(id);
    }

    @Override
    public List<Adresse> getAllAdresse() {
        return  adresseRepository.findAll();
    }

    @Override
    public void deleteAdresse(Long id) {
        adresseRepository.deleteById(id);
    }
}
