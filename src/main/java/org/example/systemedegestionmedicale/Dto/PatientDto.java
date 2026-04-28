package org.example.systemedegestionmedicale.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PatientDto {
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "Le prenom est obligatoire")
    private String prenom;
    @NotBlank(message = "Email est obligatoire")
    @Email
    private String email;
    @Size(min = 10, max = 10, message = "numero doit étre mois de 10")
    private String telephone;
    @NotNull(message = "Invalide date Naissance")
    @Past
    private LocalDate dateNaissance;

}
