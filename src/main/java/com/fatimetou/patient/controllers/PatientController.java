package com.fatimetou.patient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.fatimetou.patient.entities.Patient;
import com.fatimetou.patient.services.PatientService;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    PatientService patientServ;

    @GetMapping("/getAll/patient")
    public ResponseEntity<List<Patient>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(patientServ.listerPatient());
    }

    @PostMapping("/create/patient")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientServ.ajouterPatient(patient));
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("idP") Long idP) {
        return ResponseEntity.status(HttpStatus.OK).body(patientServ.getPatientById(idP));
    }

    @PutMapping("update/patient/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable("idP") Long id, @RequestBody Patient patient) {
        return ResponseEntity.status(HttpStatus.OK).body(patientServ.modifierPatient(patient, id));
    }
}
