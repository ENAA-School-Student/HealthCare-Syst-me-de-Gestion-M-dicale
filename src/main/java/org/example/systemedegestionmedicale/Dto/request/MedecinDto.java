package org.example.systemedegestionmedicale.Dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MedecinDto {
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "Le specialite est obligatoire")
    private String specialite;
    @NotBlank
    @Email(message = "Email est obligatoire")
    private String email;
    @Size(min = 10, max=10, message = "numero doit étre mois de 10")
    private String telephone;
}
