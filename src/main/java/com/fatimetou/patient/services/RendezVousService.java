package com.fatimetou.patient.services;
import com.fatimetou.patient.entities.RendezVous;
import com.fatimetou.patient.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousService {
    @Autowired
    RendezVousRepository rendezVousRepository;

    public RendezVous ajouterRdv(RendezVous rdv){
        return rendezVousRepository.save(rdv);
    }

    public RendezVous modifierRdv(RendezVous rendezVous,long idRdv) {

        RendezVous rendv = rendezVousRepository.findById(idRdv).orElse(null);
        if (rendezVous.getName() != null) {
            rendv.setName(rendezVous.getName());
        }
        if (rendezVous.getDate() != null) {
            rendv.setDate(rendezVous.getDate());
        }
        if (rendezVous.getStatus() != null) {
            rendv.setStatus(rendezVous.getStatus());
        }
        return rendezVousRepository.save(rendv);
    }

    public List<RendezVous> listerRdv(){
        return rendezVousRepository.findAll();
    }
}
