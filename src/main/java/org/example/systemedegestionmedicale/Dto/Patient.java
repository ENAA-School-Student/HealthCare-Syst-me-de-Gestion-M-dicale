package org.example.systemedegestionmedicale.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Patient {

    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private LocalDate DateNaissance;

}
