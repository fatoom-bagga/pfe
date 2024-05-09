package com.fatimetou.patient.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idC;

    @Column(nullable = false)
    private String motif;

    @Column(nullable = false, updatable = true)
    private int poids;

    @Column(nullable = false, updatable = true)
    private int taille;

    @Column(nullable = false, updatable = true)
    private int temperature;

    @Column(nullable = false, updatable = true)
    private int fréquenceC;

    @Column(nullable = false, updatable = true)
    private int pressArt;

    @Column(nullable = false, updatable = true)
    private int diagnostique;

    @ManyToOne(optional = true)
    private Patient patient;

    @ManyToOne(optional = true)
    private Medecin medecin;
}
