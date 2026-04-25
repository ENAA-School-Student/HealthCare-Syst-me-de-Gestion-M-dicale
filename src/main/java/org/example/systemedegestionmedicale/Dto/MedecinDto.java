package org.example.systemedegestionmedicale.Dto;


import lombok.Data;


@Data
public class MedecinDto {

    private long id;
    private String nom;
    private String specialite;
    private String email;
    private String telephone;
}
