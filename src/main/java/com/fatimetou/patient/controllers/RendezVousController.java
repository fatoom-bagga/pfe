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

import com.fatimetou.patient.entities.RendezVous;
import com.fatimetou.patient.services.RendezVousService;

@RestController
public class RendezVousController {

    @Autowired
    RendezVousService rdvserv;

    @GetMapping("/getAll/rdv")
    public ResponseEntity<List<RendezVous>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(rdvserv.listerRdv());
    }

    @PostMapping("/create/rdv")
    public ResponseEntity<RendezVous> createRdv(@RequestBody RendezVous rdv) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rdvserv.ajouterRdv(rdv));
    }

    @PutMapping("update/rdv/{id}")
    public ResponseEntity<RendezVous> updateRdv(@PathVariable("id") Long id, @RequestBody RendezVous rdv) {
        return ResponseEntity.status(HttpStatus.OK).body(rdvserv.modifierRdv(rdv, id));
    }

}
