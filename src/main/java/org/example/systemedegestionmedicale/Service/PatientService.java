package org.example.systemedegestionmedicale.Service;


import lombok.RequiredArgsConstructor;
import org.example.systemedegestionmedicale.Dto.PatientDto;
import org.example.systemedegestionmedicale.Mapper.PatientMapper;
import org.example.systemedegestionmedicale.Models.Patient;
import org.example.systemedegestionmedicale.Repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    public PatientDto ajouterPatient(PatientDto patientDto){

        Patient entity = patientMapper.toEntity((patientDto));
        Patient save = patientRepository.save(entity);
        return patientMapper.toDto(save);

    }
}
