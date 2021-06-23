package com.anies.training.membre.rest;


import com.anies.training.core.entity.membre.Membre;

import com.anies.training.membre.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MembreController {

    @Autowired
    MembreService membreService;


    // create new Membre
    @PostMapping("membre")
    public ResponseEntity<Membre>  createMembre(@RequestBody Membre membre) throws Exception{

        if (membre.getId()!=null){
            throw new Exception("A new membre cannot already have an ID");
        }
        Membre res= membreService.createMembre(membre);
        return  ResponseEntity.ok().body(res);
    }

    // update Membre
    @PutMapping("membre")
    public ResponseEntity<Membre>  updateMembre(@RequestBody Membre membre) throws Exception{
        if (membre.getId()== null){
            throw new Exception("Bad request ID invalid");
        }
        Membre res= membreService.createMembre(membre);
        return  ResponseEntity.ok().body(res);
    }


    // get all Membre
    @GetMapping("/membre")
    public ResponseEntity<List<Membre>> getAllMembre(){
        List<Membre> res= membreService.getAllMembre();

        return  ResponseEntity.ok().body(res);
    }

    // get One Membre by id
    @GetMapping("/membre/{id}")
    public ResponseEntity<Membre> getOneMembre(@PathVariable Long id){
        Membre res= membreService.getMembre(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Element not found"));

        return  ResponseEntity.ok().body(res);
    }

    @DeleteMapping("/membre/{id}")
    public void deleteMenage(@PathVariable Long id){
        membreService.deleteMembre(id);
    }





}
