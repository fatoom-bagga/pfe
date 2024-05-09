package com.fatimetou.patient.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Medecin  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String adresse;
    @Column(nullable = false)
    private String genre;

    private String type;
    @ManyToOne(optional = false)
    private Receptionniste receptionniste;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<RendezVous> rendezVous;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<Ordonnance> ordonnances;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<Bilan> bilans;
    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<Certificat> certificats;
    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<Fiche> fiches ;




}
