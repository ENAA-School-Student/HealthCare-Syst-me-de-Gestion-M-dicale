package org.example.systemedegestionmedicale.Dto;


import lombok.Data;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;

import java.time.LocalDate;

@Data
public class RendezVousDto {
    private LocalDate dateRendezVous;
    private StatusRendezVou statusRendezVou;

}
