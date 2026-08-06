package org.example.systemedegestionmedicale.Mapper;


import org.example.systemedegestionmedicale.Dto.request.PatientDto;
import org.example.systemedegestionmedicale.Dto.response.PatientResponseDto;
import org.example.systemedegestionmedicale.Models.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientDto patientDto);
    List<PatientResponseDto> todtolist(List<Patient> patients);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.email", target = "userEmail")
    @Mapping(source = "dossierMedical.id", target = "medicalId")
    @Mapping(source = "dossierMedical.diagnostic", target = "diagnostic")
    @Mapping(source = "dossierMedical.observation", target = "observation")
    @Mapping(source = "dossierMedical.dateCreation", target = "dateCreation")
    PatientResponseDto toResponseDto(Patient patient);



}
