package com.anies.training.membre.service.impl;

import com.anies.training.core.entity.adresse.Adresse;
import com.anies.training.core.entity.membre.Membre;
import com.anies.training.core.entity.menage.Menage;
import com.anies.training.membre.repository.MembreRepository;

import com.anies.training.membre.service.MembreService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;


@Service
public class MembreImpl implements MembreService {

    WebClient.Builder webClientBuilder;
    MembreRepository membreRepository;
    RestTemplate restTemplate;
    final WebClient webClientMenage;
    final WebClient webClientAdreese;


    public MembreImpl(WebClient.Builder webClientBuilder, MembreRepository membreRepository, RestTemplate restTemplate) {

        this.webClientBuilder=webClientBuilder;
        this.membreRepository=membreRepository;
        this.restTemplate=restTemplate;
        this.webClientMenage = webClientBuilder.baseUrl("http://menage-service/api").build();
        this.webClientAdreese = webClientBuilder.baseUrl("http://adresse-service/api").build();
    }


    @Override
    public Membre createMembre(Membre membre) {

        return  membreRepository.save(membre);
    }

    @Override
    public Membre updateMembre(Membre membre) {
        return membreRepository.save(membre);
    }

    @Override
    public Membre getMembre(Long id) {

        Membre membre= membreRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Menage menage= webClientMenage.get().uri("/menage/"+membre.getMenage_id()).retrieve().bodyToMono(Menage.class).block();
        Adresse adresse= webClientAdreese.get().uri("/adresse/"+menage.getAdresse_id()).retrieve().bodyToMono(Adresse.class).block();

        menage.setAdresse(adresse);
        membre.setMenage(menage);
        return membre;
    }

    @Override
    public ParallelFlux<Membre> getAllMembre() {

        List<Mono<Membre>> membresMono= new ArrayList<>();
       List<Membre> membres= membreRepository.findAll();
       membres.forEach(membre -> {

           Mono<Membre> membreMono= webClientMenage.get()
                           .uri("/menage/"+membre.getMenage_id())
                           .retrieve()
                           .bodyToMono(Menage.class)
                           .map(menage -> {
                               membre.setMenage(menage);
                               return membre;
                           });

           membresMono.add(membreMono);

          /* membre.setMenage(
                   restTemplate.getForObject("/menage/"+membre.getMenage_id(), Menage.class)
           );*/
       });

       final Flux<Membre> membreFlux= Flux.concat(membresMono);
       return membreFlux.parallel().runOn(Schedulers.boundedElastic());

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

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WebClient.Builder getWebClientBuilder() {
        return webClientBuilder;
    }

    public void setWebClientBuilder(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }
}
