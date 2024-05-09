package com.fatimetou.patient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatimetou.patient.entities.Medecin;
import com.fatimetou.patient.services.MedecinService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MedecinController {

    @Autowired
    MedecinService mdcServ;

    @GetMapping("/getAll/medecin")
    public ResponseEntity<List<Medecin>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mdcServ.listMedecin());
    }

    @PostMapping("/create/medecin")
    public ResponseEntity<Medecin> createMed(@RequestBody Medecin medecin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mdcServ.ajouterMedecin(medecin));
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Medecin> getMedcinById(@PathVariable("id") Long id) {
    // return ResponseEntity.status(HttpStatus.OK).body(mdcServ.getMedecinById(id));
    // }

}
