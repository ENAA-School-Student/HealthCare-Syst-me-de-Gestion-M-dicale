package org.example.systemedegestionmedicale.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "medecin")
@Data
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String specialite;
    private String email;
    private String telephone;


    @OneToMany(mappedBy = "medecin")
    private List<RendezVou> rendezVous;


    @OneToMany(mappedBy = "medecin")
    private List<DossierMedical> dossierMedicals;
}
