package org.example.systemedegestionmedicale.Models;


import jakarta.persistence.*;
import lombok.Data;

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
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "patient")
    private List<RendezVou> rendezVous;

}
