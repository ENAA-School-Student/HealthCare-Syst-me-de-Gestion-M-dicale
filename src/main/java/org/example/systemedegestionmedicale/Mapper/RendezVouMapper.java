package org.example.systemedegestionmedicale.Mapper;

import org.example.systemedegestionmedicale.Dto.request.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.response.RendezVouResponseDto;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RendezVouMapper {
    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "medecin.id", target = "medecinId")
    RendezVouResponseDto toResponseDto(RendezVou rendezVou);

    @Mapping(source = "patientId", target = "patient.id")
    @Mapping(source = "medecinId", target = "medecin.id")
    RendezVou toEntity(RendezVousDto rendezVousDto);
    List<RendezVouResponseDto> toDtoList(List<RendezVou> rendezVous);
}
