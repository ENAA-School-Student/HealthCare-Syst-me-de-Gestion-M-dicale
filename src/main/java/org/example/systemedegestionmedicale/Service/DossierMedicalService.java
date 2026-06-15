package org.example.systemedegestionmedicale.Service;

import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouteDiagnosticDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouterObservationsDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalDto;
import org.example.systemedegestionmedicale.Dto.response.DossierMedicalResponseDto;
import org.example.systemedegestionmedicale.Mapper.DossierMedicalMapper;
import org.example.systemedegestionmedicale.Models.DossierMedical;
import org.example.systemedegestionmedicale.Repository.DossierMedicalRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class DossierMedicalService {

    private final DossierMedicalMapper dossierMedicalMapper;
    private final DossierMedicalRepository dossierMedicalRepository;

    public DossierMedicalService(DossierMedicalRepository dossierMedicalRepository, DossierMedicalMapper dossierMedicalMapper){
        this.dossierMedicalRepository = dossierMedicalRepository;
        this.dossierMedicalMapper = dossierMedicalMapper;
    }


    public DossierMedicalResponseDto CreerDossierMedical(DossierMedicalDto dossierMedicalDto){
        DossierMedical entity = dossierMedicalMapper.toEntity(dossierMedicalDto);
        DossierMedical saveDossier = dossierMedicalRepository.save(entity);
        return dossierMedicalMapper.toResponseDto(saveDossier);
    }


    public DossierMedicalResponseDto ajouterDiagnostic(long id, DossierMedicalAjouteDiagnosticDto dossier){

        DossierMedical saveDiagnostic = dossierMedicalRepository.findDossierMedicalByPatient_Id(id)
                .orElseThrow(() -> new RuntimeException("Dossier médical introuvable."));

        saveDiagnostic.setDiagnostic(dossier.getDiagnostic());
        DossierMedical update = dossierMedicalRepository.save(saveDiagnostic);

        return dossierMedicalMapper.toResponseDto(update);
    }


    public DossierMedicalResponseDto ajouterObservations(long id, DossierMedicalAjouterObservationsDto dossierMedicalAjouterObservationsDto){

        DossierMedical saveObservations = dossierMedicalRepository.findDossierMedicalByPatient_Id(id)
                .orElseThrow(() -> new RuntimeException("Dossier médical introuvable."));

        saveObservations.setObservation(dossierMedicalAjouterObservationsDto.getObservation());
        DossierMedical update = dossierMedicalRepository.save(saveObservations);

        return dossierMedicalMapper.toResponseDto(update);
    }

    @Cacheable(value = "MEDICAL_CACHE", key = "#id")
    public DossierMedicalResponseDto consulterDossierMedical(long id) {

        DossierMedical dossier = dossierMedicalRepository.findDossierMedicalByPatient_Id(id)
                .orElseThrow(() -> new RuntimeException("Dossier médical introuvable."));


        return dossierMedicalMapper.toResponseDto(dossier);
    }
}