package org.example.systemedegestionmedicale.Dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class DossierMedicalDto {
    private String diagnostic;
    private String observation;
    private LocalDate dateCreation;
    private long patientId;
    private long medecinId;
}
