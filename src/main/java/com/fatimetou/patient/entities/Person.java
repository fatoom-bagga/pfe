package com.fatimetou.patient.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String adresse;
}