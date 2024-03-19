package com.fatimetou.patient.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Utilisateur extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Remove this code

    // @Column(nullable = false, unique = false)
    // private String nomU;

    // @Column(nullable = false, unique = false)
    // private String prenomU;

    // @Column(nullable = false, unique = true)
    // private String email;

    // @Column(nullable = false, unique =true, updatable = true)
    // private String mdp;



    @OneToOne(mappedBy = "utilisateur")
    private Medecin medecin;

    @OneToOne(mappedBy = "utilisateur")
    private Receptionniste receptionniste;

    @CreationTimestamp
    private LocalDateTime creeA;

    @LastModifiedDate
    private LocalDateTime modifieA;
}
