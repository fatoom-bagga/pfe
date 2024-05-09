package com.fatimetou.patient.entities;

import com.fatimetou.patient.enums.RendezVousStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRdv;

    @Column(nullable = false, updatable = true)
    private Date date;
    private String motif;

    private RendezVousStatus status;

    private LocalTime heure;

    @ManyToOne(optional = true)
    private Patient patient;

    @ManyToOne(optional = true)
    private Medecin medecin;
}

