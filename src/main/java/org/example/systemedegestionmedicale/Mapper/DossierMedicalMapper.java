package org.example.systemedegestionmedicale.Mapper;


import org.example.systemedegestionmedicale.Dto.DossierMedicalAjouteDiagnosticDto;
import org.example.systemedegestionmedicale.Dto.DossierMedicalAjouterObservationsDto;
import org.example.systemedegestionmedicale.Dto.DossierMedicalDto;
import org.example.systemedegestionmedicale.Models.DossierMedical;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DossierMedicalMapper {

    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "medecin.id", target = "medecinId")
    DossierMedicalDto toDto(DossierMedical dossierMedical);

    @Mapping(source = "patientId", target = "patient.id")
    @Mapping(source = "medecinId", target = "medecin.id")
    DossierMedical toEntity(DossierMedicalDto dossierMedicalDto);

    DossierMedical toAjoutediagnostic(DossierMedicalAjouteDiagnosticDto dossierMedicalAjouteDiagnosticDto);


    List<DossierMedicalDto> toDtoList(List<DossierMedical> dossierMedicals);
}
