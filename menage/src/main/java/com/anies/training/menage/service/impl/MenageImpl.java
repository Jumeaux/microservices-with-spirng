package com.anies.training.menage.service.impl;

import com.anies.training.core.entity.adresse.Adresse;
import com.anies.training.core.entity.menage.Menage;

import com.anies.training.menage.repository.MenageRepository;
import com.anies.training.menage.service.MenageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class MenageImpl implements MenageService {

    @Autowired
    MenageRepository menageRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Menage createMenage(Menage menage) {

        return menageRepository.save(menage);
    }

    @Override
    public Menage updateMenage(Menage menage) {

        return menageRepository.save(menage);
    }

    @Override
    public Optional<Menage> getMenage(Long id) {
        return menageRepository.findById(id);
    }

    @Override
    public List<Menage> getAllMenage() {


          List<Menage> menages=menageRepository.findAll();
          menages.forEach(menage -> {
              menage.setAdresse(
                      restTemplate.getForObject("http://adresse-service/api/adresse/"+menage.getAdresse_id(), Adresse.class)
              );
          });

          return menages;
    }

    @Override
    public void deleteMenage(Long id) {
        menageRepository.deleteById(id);
    }

    public MenageRepository getMenageRepository() {
        return menageRepository;
    }

    public void setMenageRepository(MenageRepository menageRepository) {
        this.menageRepository = menageRepository;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
