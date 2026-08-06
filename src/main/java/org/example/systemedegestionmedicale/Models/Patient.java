package org.example.systemedegestionmedicale.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String Telephone;
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RendezVou> rendezVous;

    @OneToOne(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
    private DossierMedical dossierMedical;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
