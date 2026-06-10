package org.example.systemedegestionmedicale.Dto.response;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class DossierMedicalResponseDto implements Serializable {
    private long id;
    private String diagnostic;
    private String observation;
    private LocalDate dateCreation;
    private long patientId;
}
