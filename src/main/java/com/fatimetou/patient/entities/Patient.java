package com.fatimetou.patient.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class Patient extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idP;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private String nationnalité;

    private String groupeS;

    @ManyToOne
    private Receptionniste receptionniste;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fiche_id", referencedColumnName = "id")
    private Fiche fiche;
}
