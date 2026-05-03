package org.example.systemedegestionmedicale.Dto.response;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DossierMedicalResponseDto {
    private long id;
    private String diagnostic;
    private String observation;
    private LocalDate dateCreation;
    private long patientId;
}
