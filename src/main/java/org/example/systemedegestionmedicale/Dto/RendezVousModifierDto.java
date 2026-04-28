package org.example.systemedegestionmedicale.Dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class RendezVousModifierDto {
    @NotNull(message = "Rendez Vous est obligatoire")
    @Future
    private LocalDate dateRendezVous;
    @NotBlank(message = "Status est obligatoire")
    private StatusRendezVou statusRendezVou;
}
