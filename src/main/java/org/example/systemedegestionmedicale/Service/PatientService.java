package org.example.systemedegestionmedicale.Service;



import org.example.systemedegestionmedicale.Dto.request.PatientDto;
import org.example.systemedegestionmedicale.Dto.response.PatientResponseDto;
import org.example.systemedegestionmedicale.Mapper.PatientMapper;
import org.example.systemedegestionmedicale.Models.Patient;
import org.example.systemedegestionmedicale.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private  PatientRepository patientRepository;
    private  PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper){
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }


    public PatientResponseDto ajouterPatient(PatientDto patientDto){
        Patient entity = patientMapper.toEntity(patientDto);
        Patient save = patientRepository.save(entity);
        return patientMapper.toResponseDto(save);

    }

    public PatientResponseDto modifierPatient(long id, PatientDto patientDto){
        Patient saveId = patientRepository.findById(id).orElse(null);

        saveId.setNom(patientDto.getNom());
        saveId.setPrenom(patientDto.getPrenom());
        saveId.setEmail(patientDto.getEmail());
        saveId.setTelephone(patientDto.getTelephone());
        saveId.setDateNaissance(patientDto.getDateNaissance());

        Patient update = patientRepository.save(saveId);
        return patientMapper.toResponseDto(update);
    }

    public void supprimerPatient(long id){
        patientRepository.deleteById(id);
    }

    public List<PatientResponseDto> listerPatients(){
        return patientMapper.todtolist(patientRepository.findAll());
    }

    public PatientResponseDto consulterPatient(long id){
       Patient findPatient = patientRepository.findById(id).orElse(null);
       return patientMapper.toResponseDto(findPatient);
    }

}
