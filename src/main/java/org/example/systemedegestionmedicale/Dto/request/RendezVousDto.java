package org.example.systemedegestionmedicale.Dto.request;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;

import java.time.LocalDate;

@Getter
@Setter
public class RendezVousDto {
    @NotNull(message = "Rendez Vous est obligatoire")
    @Future
    private LocalDate dateRendezVous;
    private StatusRendezVou statusRendezVou;
    @NotNull(message = "patient est obligatoire")
    private long patientId;
    @NotNull(message = "medecin est obligatoire")
    private long medecinId;

}
