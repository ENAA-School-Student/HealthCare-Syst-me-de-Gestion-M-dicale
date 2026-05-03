package org.example.systemedegestionmedicale.Mapper;


import org.example.systemedegestionmedicale.Dto.request.MedecinDto;
import org.example.systemedegestionmedicale.Dto.response.MedecinResponseDto;
import org.example.systemedegestionmedicale.Models.Medecin;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedecinMapper {

    MedecinResponseDto toResponseDto(Medecin medecin);
    Medecin toEntity(MedecinDto medecinDto);
    List<MedecinResponseDto> toDtoList(List<Medecin> medecins);
}
