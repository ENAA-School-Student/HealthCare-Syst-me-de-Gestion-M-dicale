package org.example.systemedegestionmedicale.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Medecin")
@Data
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String specialite;
    private String email;
    private String telephone;
}
