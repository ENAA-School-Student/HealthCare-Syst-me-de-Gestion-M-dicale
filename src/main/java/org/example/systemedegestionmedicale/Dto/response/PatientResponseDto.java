package org.example.systemedegestionmedicale.Dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class PatientResponseDto {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String Telephone;
    private LocalDate dateNaissance;
}
