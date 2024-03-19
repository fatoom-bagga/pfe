package com.fatimetou.patient.services;

import com.fatimetou.patient.entities.Patient;
import com.fatimetou.patient.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public Patient ajouterPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public String modifierPatient(Patient updatedPatient, long idP) {
        Patient patient = patientRepository.findById(idP).orElse(null);
        if (patient != null) {
            if (updatedPatient.getNom() != null) {
                patient.setNom(updatedPatient.getNom());

            }
            if (updatedPatient.getDateNaissance() != null) {
                patient.setDateNaissance(updatedPatient.getDateNaissance());

            }
            patientRepository.save(patient);
            return "Patient  updated !";
        }

        else {
            return "Patient not updated !";

        }

    }

    public List<Patient> listerPatient() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long idP) {
        return patientRepository.findById(idP)
                .orElseThrow(() -> new EntityNotFoundException("Prescription not found with id " + idP));
    }

    public String getPatientName(Long idP) {
        Patient patient = patientRepository.findById(idP).orElse(null);

        if (patient.getNom() != null) {
            return patient.getNom();
        } else {

            return "null";
        }
    }
}
