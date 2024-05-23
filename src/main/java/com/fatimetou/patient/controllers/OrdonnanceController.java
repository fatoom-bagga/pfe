package com.fatimetou.patient.controllers;

import java.util.List;

import com.fatimetou.patient.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.fatimetou.patient.entities.Ordonnance;
import com.fatimetou.patient.services.OrdonnanceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class OrdonnanceController {

    @Autowired
    OrdonnanceService ordServ;

    //Ha4e exemple ykank tgouli 3an 4i endpoint ygd yd5lhe la 7ad 3ndou role MEDECIN
    @PreAuthorize("hasAuthority('MEDECIN')")
    @GetMapping("/getAll/ord")
    public ResponseEntity<List<Ordonnance>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(ordServ.listerOrdonnance());
    }

    @PostMapping("/create/ord/{patientId}")
    public ResponseEntity<Ordonnance> createOrd(@PathVariable(name = "patientId") Long id,@RequestBody Ordonnance ord) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordServ.createOrdonnance(id,ord));
    }

    @GetMapping("/ord/{id}")
    public ResponseEntity<Ordonnance> getOrdonnceById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ordServ.getOrdonnanceById(id));
    }

    @PutMapping("update/ordonnance/{id}")
    public ResponseEntity<Ordonnance> updateOrd(@PathVariable("id") Long id, @RequestBody Ordonnance ord) {
        return ResponseEntity.status(HttpStatus.OK).body(ordServ.modifierOrd(ord,id));
    }

}
