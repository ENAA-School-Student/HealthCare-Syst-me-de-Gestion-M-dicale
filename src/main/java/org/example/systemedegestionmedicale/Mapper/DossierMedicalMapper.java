package org.example.systemedegestionmedicale.Mapper;


import org.example.systemedegestionmedicale.Dto.DossierMedicalDto;
import org.example.systemedegestionmedicale.Models.DossierMedical;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DossierMedicalMapper {

    DossierMedicalDto toDto(DossierMedical dossierMedical);

    DossierMedical toEntity(DossierMedicalDto dossierMedicalDto);
}
