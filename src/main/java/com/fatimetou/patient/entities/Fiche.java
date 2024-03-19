package com.fatimetou.patient.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Fiche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String antecedM;

    private String antecedCh;

    private String statusVacc;

    private String commentaire;

    @ManyToOne(optional = false)
    private Medecin medecin;

    @OneToOne(mappedBy = "fiche")
    private Patient patient;
}
