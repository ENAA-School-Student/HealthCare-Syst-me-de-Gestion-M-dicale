package org.example.systemedegestionmedicale.Mapper;


import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouteDiagnosticDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalDto;
import org.example.systemedegestionmedicale.Dto.response.DossierMedicalResponseDto;
import org.example.systemedegestionmedicale.Models.DossierMedical;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DossierMedicalMapper {

    @Mapping(source = "patient.id", target = "patientId")
    DossierMedicalResponseDto toResponseDto(DossierMedical dossierMedical);

    @Mapping(source = "patientId", target = "patient.id")
    DossierMedical toEntity(DossierMedicalDto dossierMedicalDto);

    DossierMedicalAjouteDiagnosticDto toAjoutediagnosticDto(DossierMedical dossierMedical);
    DossierMedical toAjoutediagnosticEntity(DossierMedicalAjouteDiagnosticDto DossierMedicalAjouteDiagnosticDto);



    List<DossierMedicalDto> toDtoList(List<DossierMedical> dossierMedicals);
}
