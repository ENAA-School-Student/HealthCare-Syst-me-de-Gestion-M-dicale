package org.example.systemedegestionmedicale.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class RendezVousDto {
    private LocalDate dateRendezVous;
    private StatusRendezVou statusRendezVou;
    private long patientId;
    private long medecinId;

}
