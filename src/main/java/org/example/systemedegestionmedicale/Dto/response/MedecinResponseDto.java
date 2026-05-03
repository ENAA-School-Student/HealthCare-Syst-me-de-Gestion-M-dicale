package org.example.systemedegestionmedicale.Dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedecinResponseDto {
    private long id;
    private String nom;
    private String specialite;
    private String email;
    private String telephone;
}
