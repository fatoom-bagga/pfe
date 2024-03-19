package com.fatimetou.patient.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Certificat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idC;

    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private Medecin medecin;
}
