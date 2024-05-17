package com.fatimetou.patient.services;
import com.fatimetou.patient.entities.Medecin;
import com.fatimetou.patient.repositories.MedecinRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MedecinService {
    @Autowired
    MedecinRepository medecinRepository;

    public Medecin ajouterMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    public List<Medecin> listMedecin() {
        return medecinRepository.findAll();
    }

    public Medecin getConnectedMedecin() {
        // In a real application, you would retrieve the logged-in doctor's details from the security context
        // For demonstration, let's assume the first doctor in the database is the connected one
        return medecinRepository.findById(1L).orElse(null); // Replace with actual logic
    }


    }
