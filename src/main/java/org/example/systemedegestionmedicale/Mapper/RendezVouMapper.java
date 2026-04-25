package org.example.systemedegestionmedicale.Mapper;

import org.example.systemedegestionmedicale.Dto.RendezVousDto;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RendezVouMapper {

    RendezVousDto toDto(RendezVou rendezVou);
    RendezVou toEntity(RendezVousDto rendezVousDto);
}
