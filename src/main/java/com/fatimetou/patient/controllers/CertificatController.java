package com.fatimetou.patient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fatimetou.patient.entities.Certificat;
import com.fatimetou.patient.repositories.CertificatRepository;
import com.fatimetou.patient.services.CertificatService;

public class CertificatController {
    @Autowired
    CertificatService certificatService;

    @GetMapping("/all/cert")
    public ResponseEntity<List<Certificat>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(certificatService.listerCertificat());
    }

    @PostMapping("/create/cert")
    public ResponseEntity<Certificat> createCert(@RequestBody Certificat certf) {
        return ResponseEntity.status(HttpStatus.CREATED).body(certificatService.ajouterCertf(certf));
    }

    @GetMapping("/cert/{id}")
    public ResponseEntity<Certificat> getCertById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(certificatService.getCertificatById(id));
    }

}
