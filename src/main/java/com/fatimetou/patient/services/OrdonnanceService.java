package com.fatimetou.patient.services;

import com.fatimetou.patient.entities.Medecin;
import com.fatimetou.patient.entities.Ordonnance;
import com.fatimetou.patient.entities.Patient;
import com.fatimetou.patient.exception.OrdNotFoundException;
import com.fatimetou.patient.exception.PatientNotFoundException;
import com.fatimetou.patient.repositories.OrdonnanceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdonnanceService {
    @Autowired
    OrdonnanceRepository ordonnanceRepository;
    @Autowired
    private MedecinService medecinService;
    @Autowired
    private PatientService patientService;

    public List<Ordonnance> listerOrdonnance() {
        return ordonnanceRepository.findAll();
    }

    public Ordonnance createOrdonnance(Ordonnance ordonnance) {
        Medecin connectedMedecin = medecinService.getConnectedMedecin();


        if (connectedMedecin != null) {

            ordonnance.setMedecin(connectedMedecin);
        }
        else {
            throw new RuntimeException("Aucun médecin n'est connecté pour créer l'ordonnance.");
        }

        Patient patient = ordonnance.getPatient();

        if (patient != null) {
            ordonnance.setPatient(patient);
        }
        else {
            throw new RuntimeException("Aucun patient n'est associé à cette ordonnance.");
        }
        return ordonnanceRepository.save(ordonnance);
    }


    public Ordonnance getOrdonnanceById(Long idOrd) {
        return ordonnanceRepository.findById(idOrd).
                orElseThrow(() -> new EntityNotFoundException("Prescription not found with id " + idOrd));
    }
    public Ordonnance modifierOrd(Ordonnance updateOrd, Long id) {
        Ordonnance ord=ordonnanceRepository.findById(id).orElseThrow(()->new OrdNotFoundException(id));



        return ordonnanceRepository.save(ord);
    }
}
