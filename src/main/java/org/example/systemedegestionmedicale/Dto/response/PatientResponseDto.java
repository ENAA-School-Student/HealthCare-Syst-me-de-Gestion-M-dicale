package org.example.systemedegestionmedicale.Dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
public class PatientResponseDto implements Serializable {
    private long id;
    private String nom;
    private String prenom;
    private String Telephone;
    private LocalDate dateNaissance;
}
