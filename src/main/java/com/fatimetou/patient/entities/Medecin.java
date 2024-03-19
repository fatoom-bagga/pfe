package com.fatimetou.patient.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medecin extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idM;

    @Column(nullable = false)
    private String genre;

    @ManyToOne(optional = false)
    private Receptionniste receptionniste;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "futilisateur_id", referencedColumnName = "id")
    private Utilisateur utilisateur;

}
