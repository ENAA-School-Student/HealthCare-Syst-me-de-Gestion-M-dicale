package org.example.systemedegestionmedicale.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DossierMedicalAjouteDiagnosticDto {
    @NotBlank(message = "diagnostic est obligatoire")
    private String diagnostic;
}
