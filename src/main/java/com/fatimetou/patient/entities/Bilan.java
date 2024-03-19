package com.fatimetou.patient.entities;

import com.fatimetou.patient.enums.BilanType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bilan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idB;

    private String nomB;

    private BilanType typeB;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private Medecin medecin;
}
