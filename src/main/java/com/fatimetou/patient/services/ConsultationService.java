package com.fatimetou.patient.services;
import com.fatimetou.patient.entities.Consultation;
import com.fatimetou.patient.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    ConsultationRepository consultRepository;

    public Consultation ajouterConslt(Consultation conslt) {
        return consultRepository.save(conslt);
    }

    public List<Consultation> listerConslt() {
        return consultRepository.findAll();
    }
}
