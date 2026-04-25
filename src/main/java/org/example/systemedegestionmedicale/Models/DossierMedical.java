package org.example.systemedegestionmedicale.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "dossier_medical")
@Data
public class DossierMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String diagnostic;
    private String observation;
    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;
}
