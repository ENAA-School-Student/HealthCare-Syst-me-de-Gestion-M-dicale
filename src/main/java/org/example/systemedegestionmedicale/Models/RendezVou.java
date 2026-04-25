package org.example.systemedegestionmedicale.Models;


import jakarta.persistence.*;
import lombok.Data;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;

import java.time.LocalDate;

@Entity
@Table(name = "rendezvous")
@Data
public class RendezVou {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dateRendezVous;
    private StatusRendezVou status;


    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;

}
