package org.example.systemedegestionmedicale.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "dossierMedical")
@Data
public class DossierMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String diagnostic;
    private String observation;
    private LocalDate dateCreation;

    @OneToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;
}
