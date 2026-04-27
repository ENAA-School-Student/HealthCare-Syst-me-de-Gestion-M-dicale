package org.example.systemedegestionmedicale.Mapper;


import org.example.systemedegestionmedicale.Dto.MedecinDto;
import org.example.systemedegestionmedicale.Models.Medecin;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedecinMapper {

    MedecinDto toDto(Medecin medecin);
    Medecin toEntity(MedecinDto medecinDto);
    List<MedecinDto> toDtoList(List<Medecin> medecins);
}
