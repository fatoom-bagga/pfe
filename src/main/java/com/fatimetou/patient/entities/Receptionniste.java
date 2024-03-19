package com.fatimetou.patient.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receptionniste extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idR;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "futilisateur_id", referencedColumnName = "id")
    private Utilisateur utilisateur;
}
