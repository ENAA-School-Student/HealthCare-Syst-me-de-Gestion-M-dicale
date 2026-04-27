package org.example.systemedegestionmedicale.Mapper;

import org.example.systemedegestionmedicale.Dto.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.RendezVousModifierDto;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RendezVouMapper {
    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "medecin.id", target = "medecinId")
    RendezVousDto toDto(RendezVou rendezVou);

    @Mapping(source = "patientId", target = "patient.id")
    @Mapping(source = "medecinId", target = "medecin.id")
    RendezVou toEntity(RendezVousDto rendezVousDto);

    RendezVou toModifier(RendezVousModifierDto rendezVousModifierDto);

    List<RendezVousDto> toDtoList(List<RendezVou> rendezVous);
}
