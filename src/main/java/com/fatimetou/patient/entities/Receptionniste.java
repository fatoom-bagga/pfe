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

public class Receptionniste extends User {

    @OneToMany(mappedBy = "receptionniste", cascade = CascadeType.ALL)
    private List<Medecin> medecins;
    @OneToMany(mappedBy = "receptionniste", cascade = CascadeType.ALL)
    private List<Patient> patients;

}
