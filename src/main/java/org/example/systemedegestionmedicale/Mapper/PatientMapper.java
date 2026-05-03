package org.example.systemedegestionmedicale.Mapper;


import org.example.systemedegestionmedicale.Dto.request.PatientDto;
import org.example.systemedegestionmedicale.Dto.response.PatientResponseDto;
import org.example.systemedegestionmedicale.Models.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientDto patientDto);
    List<PatientResponseDto> todtolist(List<Patient> patients);

    PatientResponseDto toResponseDto(Patient patient);



}
