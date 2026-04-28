package org.example.systemedegestionmedicale.Dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DossierMedicalDto {
    @NotBlank(message = "diagnostic est obligatoire")
    private String diagnostic;
    @NotBlank(message = "observation est obligatoire")
    private String observation;
    private LocalDate dateCreation;
    @NotNull(message = "patient est obligatoire")
    private long patientId;
    @NotNull(message = "medecin est obligatoire")
    private long medecinId;
}
