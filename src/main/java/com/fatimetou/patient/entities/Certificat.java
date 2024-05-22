package com.fatimetou.patient.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Certificat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idC;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date date;
    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = true)
    private Medecin medecin;
}
