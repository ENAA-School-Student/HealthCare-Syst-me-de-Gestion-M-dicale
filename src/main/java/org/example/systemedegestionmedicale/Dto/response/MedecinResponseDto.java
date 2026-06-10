package org.example.systemedegestionmedicale.Dto.response;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MedecinResponseDto implements  Serializable {
    private long id;
    private String nom;
    private String specialite;
    private String telephone;
}
