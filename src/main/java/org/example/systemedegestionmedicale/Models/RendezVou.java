package org.example.systemedegestionmedicale.Models;


import jakarta.persistence.*;
import lombok.Data;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;

import java.time.LocalDate;

@Entity
@Table(name = "rendez_vou")
@Data
public class RendezVou {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date_rendez_vous")
    private LocalDate dateRendezVous;
    @Column(name = "status_rendez_vou")
    @Enumerated(EnumType.STRING)
    private StatusRendezVou statusRendezVou;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

}
