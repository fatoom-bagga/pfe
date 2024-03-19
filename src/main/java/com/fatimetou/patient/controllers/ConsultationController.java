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

import com.fatimetou.patient.entities.Consultation;
import com.fatimetou.patient.services.ConsultationService;

@RestController

public class ConsultationController {

    @Autowired
    ConsultationService consServ;
    @GetMapping("/all/consult")
    public ResponseEntity<List<Consultation>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(consServ.listerConslt());
    }

    @PostMapping("/create/consult")
    public ResponseEntity<Consultation> createPatient(@RequestBody Consultation conslt) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consServ.ajouterConslt(conslt));
    }

}
