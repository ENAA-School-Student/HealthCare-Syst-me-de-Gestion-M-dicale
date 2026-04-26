package org.example.systemedegestionmedicale.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDto {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private LocalDate dateNaissance;

}
