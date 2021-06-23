package com.anies.training.menage.rest;


import com.anies.training.core.entity.menage.Menage;

import com.anies.training.menage.service.MenageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenageController {

    @Autowired
    MenageService menageService;


    // create new Menage
    @PostMapping("menage")
    public ResponseEntity<Menage>  createMenage(@RequestBody Menage menage) throws Exception{

        if (menage.getId()!=null){
            throw new Exception("A new menage cannot already have an ID");
        }
        Menage res= menageService.createMenage(menage);
        return  ResponseEntity.ok().body(res);
    }

    // update Menage
    @PutMapping("menage")
    public ResponseEntity<Menage>  updateMenage(@RequestBody Menage menage) throws Exception{
        if (menage.getId()== null){
            throw new Exception("Bad request ID invalid");
        }
        Menage res= menageService.createMenage(menage);
        return  ResponseEntity.ok().body(res);
    }


    // get all Menage
    @GetMapping("/menage")
    public ResponseEntity<List<Menage>> getAllMenage(){
        List<Menage> res= menageService.getAllMenage();

        return  ResponseEntity.ok().body(res);
    }

    // get One Menage by id
    @GetMapping("/menage/{id}")
    public ResponseEntity<Menage> getOneMenage(@PathVariable Long id){
        Menage res= menageService.getMenage(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Element non trouvé en base"));

        return  ResponseEntity.ok().body(res);
    }

    @DeleteMapping("/menage/{id}")
    public void deleteMenage(@PathVariable Long id){
        menageService.deleteMenage(id);
    }





}
