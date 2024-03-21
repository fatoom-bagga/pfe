package com.fatimetou.patient.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Receptionniste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idR;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "futilisateur_id", referencedColumnName = "id")
    private Utilisateur utilisateur;

    @OneToOne
    private User user;
}
