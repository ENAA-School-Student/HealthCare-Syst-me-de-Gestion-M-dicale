package org.example.systemedegestionmedicale.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String Telephone;
    private LocalDate dateNaissance;

    @OneToMany
    private List<RendezVou> rendezVous;

    @OneToOne
    private DossierMedical dossierMedical;
}
