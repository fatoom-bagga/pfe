package com.fatimetou.patient.entities;

import com.fatimetou.patient.enums.RendezVousStatus;
import jakarta.persistence.*;
import lombok.*;

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

    private RendezVousStatus status;

    private String name;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private RendezVous rendezVous;
}

