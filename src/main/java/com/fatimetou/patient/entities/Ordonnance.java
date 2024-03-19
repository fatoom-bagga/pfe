package com.fatimetou.patient.entities;
import jakarta.persistence.*;
import org.hibernate.type.TrueFalseConverter;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ordonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrd;

    @Column(nullable = false, unique = true)
    private String nomOrd;

    @Column(nullable = false, unique = false)
    private String observation;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private Medecin medecin;
}
