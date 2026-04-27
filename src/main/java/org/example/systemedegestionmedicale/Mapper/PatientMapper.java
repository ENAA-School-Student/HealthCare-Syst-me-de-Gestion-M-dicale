package org.example.systemedegestionmedicale.Mapper;


import org.example.systemedegestionmedicale.Dto.PatientDto;
import org.example.systemedegestionmedicale.Models.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDto toDto(Patient patient);
    Patient toEntity(PatientDto patientDto);
    List<PatientDto> todtolist(List<Patient> patients);

}
