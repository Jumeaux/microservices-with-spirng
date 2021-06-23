package com.anies.training.membre.service.impl;

import com.anies.training.core.entity.membre.Membre;
import com.anies.training.core.entity.menage.Menage;
import com.anies.training.membre.repository.MembreRepository;

import com.anies.training.membre.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class MembreImpl implements MembreService {

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Membre createMembre(Membre membre) {

        return  membreRepository.save(membre);
    }

    @Override
    public Membre updateMembre(Membre membre) {
        return membreRepository.save(membre);
    }

    @Override
    public Optional<Membre> getMembre(Long id) {

        return membreRepository.findById(id);
    }

    @Override
    public List<Membre> getAllMembre() {

       List<Membre> membres= membreRepository.findAll();
       membres.forEach(membre -> {

           membre.setMenage(
                   restTemplate.getForObject("http://localhost:8083/api/menage/"+membre.getMenage_id(), Menage.class)
           );
       });

       return  membres;
    }

    @Override
    public void deleteMembre(Long id) {
        membreRepository.deleteById(id);
    }

    public MembreRepository getMembreRepository() {
        return membreRepository;
    }

    public void setMembreRepository(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }
}
