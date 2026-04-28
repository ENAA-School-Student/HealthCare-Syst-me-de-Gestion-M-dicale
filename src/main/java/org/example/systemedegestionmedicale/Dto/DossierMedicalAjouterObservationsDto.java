package org.example.systemedegestionmedicale.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DossierMedicalAjouterObservationsDto {
    @NotBlank(message = "observation est obligatoire")
    private String observation;
}
