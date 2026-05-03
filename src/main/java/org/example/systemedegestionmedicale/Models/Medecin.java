package org.example.systemedegestionmedicale.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "medecin")
@Getter
@Setter
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
}
