package org.example.systemedegestionmedicale.Dto.response;


import lombok.Getter;
import lombok.Setter;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;

import java.time.LocalDate;

@Getter
@Setter
public class RendezVouResponseDto {
    private long id;
    private LocalDate dateRendezVous;
    private StatusRendezVou statusRendezVou;
    private long patientId;
    private long medecinId;
}
