package com.fatimetou.patient.services;

import com.fatimetou.patient.entities.Ordonnance;
import com.fatimetou.patient.repositories.OrdonnanceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdonnanceService {
    @Autowired
    OrdonnanceRepository ordonnanceRepository;

    public List<Ordonnance> listerOrdonnance() {
        return ordonnanceRepository.findAll();
    }

    public Ordonnance ajouterOrd(Ordonnance ordonnance) {
        return ordonnanceRepository.save(ordonnance);
    }

    public Ordonnance getOrdonnanceById(Long idOrd) {
        return ordonnanceRepository.findById(idOrd).
                orElseThrow(() -> new EntityNotFoundException("Prescription not found with id " + idOrd));
    }

}
