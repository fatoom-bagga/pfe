package com.fatimetou.patient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatimetou.patient.entities.Ordonnance;
import com.fatimetou.patient.services.OrdonnanceService;

@RestController
public class OrdonnanceController {

    @Autowired
    OrdonnanceService ordServ;

    @GetMapping("/getAll/ord")
    public ResponseEntity<List<Ordonnance>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(ordServ.listerOrdonnance());
    }

    @PostMapping("/create/ord")
    public ResponseEntity<Ordonnance> createOrd(@RequestBody Ordonnance ord) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordServ.ajouterOrd(ord));
    }

    @GetMapping("/ord/{id}")
    public ResponseEntity<Ordonnance> getOrdonnceById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ordServ.getOrdonnanceById(id));
    }

    // @PutMapping("update/{id}")
    // public ResponseEntity<String> updateOrdEntity(@PathVariable("id") Long id,
    // @RequestBody Ordonnance ord) {
    // return ResponseEntity.status(HttpStatus.OK).body(ordServ.);
    // }
}
