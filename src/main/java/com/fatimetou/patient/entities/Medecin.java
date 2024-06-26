package com.fatimetou.patient.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String etatCivil;
    private String nationnalite;
    private String prenom;
    private String adresse;
    @Column()
    private String genre;

    private String type;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RendezVous> rendezVous;


    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Bilan> bilans;
    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Certificat> certificats;
    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Fiche> fiches;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    private User user;

}
