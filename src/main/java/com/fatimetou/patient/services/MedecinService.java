package com.fatimetou.patient.services;
import com.fatimetou.patient.entities.Medecin;
import com.fatimetou.patient.entities.Utilisateur;
import com.fatimetou.patient.repositories.MedecinRepository;
import com.fatimetou.patient.repositories.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MedecinService {
    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Medecin ajouterMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    public List<Medecin> listMedecin() {
        return medecinRepository.findAll();
    }

    public String getMedecinName(Long idU) {

        Utilisateur utilisateur = utilisateurRepository.findById(idU)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur not found with id " + idU));

        Medecin medecin = utilisateur.getMedecin();
        if (medecin != null) {
            return medecin.getUser().getNom();
        } else {

            return "Utilisateur non associé à un médecin";
        }
    }

    }
