package org.example.systemedegestionmedicale.Service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.systemedegestionmedicale.Dto.PatientDto;
import org.example.systemedegestionmedicale.Mapper.PatientMapper;
import org.example.systemedegestionmedicale.Models.Patient;
import org.example.systemedegestionmedicale.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    public PatientDto ajouterPatient(PatientDto patientDto){

        Patient entity = patientMapper.toEntity((patientDto));
        Patient save = patientRepository.save(entity);
        return patientMapper.toDto(save);

    }

    public PatientDto modifierPatient(long id, PatientDto patientDto){
        Patient entity = patientMapper.toEntity(patientDto);
        Patient saveId = patientRepository.findById(id).orElse(null);

        saveId.setNom(entity.getNom());
        saveId.setPrenom(entity.getPrenom());
        saveId.setEmail(entity.getEmail());
        saveId.setTelephone(entity.getTelephone());
        saveId.setDateNaissance(entity.getDateNaissance());

        Patient update = patientRepository.save(saveId);
        return patientMapper.toDto(update);
    }

    public void supprimerPatient(long id){
        patientRepository.deleteById(id);
    }

    public List<PatientDto> listerPatients(){
        return patientMapper.todtolist(patientRepository.findAll());
    }

    public PatientDto consulterPatient(long id){
       Patient findPatient = patientRepository.findById(id).orElse(null);
       return patientMapper.toDto(findPatient);
    }

}
