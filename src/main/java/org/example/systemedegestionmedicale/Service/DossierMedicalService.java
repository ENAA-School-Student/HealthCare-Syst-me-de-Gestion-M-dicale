package org.example.systemedegestionmedicale.Service;

import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouteDiagnosticDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouterObservationsDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalDto;
import org.example.systemedegestionmedicale.Dto.response.DossierMedicalResponseDto;
import org.example.systemedegestionmedicale.Mapper.DossierMedicalMapper;
import org.example.systemedegestionmedicale.Models.DossierMedical;
import org.example.systemedegestionmedicale.Repository.DossierMedicalRepository;
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

    private boolean isUserMedecin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().toUpperCase().contains("MEDECIN")
                        || a.getAuthority().toUpperCase().contains("ADMIN"));
    }

    public DossierMedicalResponseDto CreerDossierMedical(DossierMedicalDto dossierMedicalDto){
        DossierMedical entity = dossierMedicalMapper.toEntity(dossierMedicalDto);
        DossierMedical saveDossier = dossierMedicalRepository.save(entity);
        return dossierMedicalMapper.toResponseDto(saveDossier);
    }


    public DossierMedicalResponseDto ajouterDiagnostic(long id, DossierMedicalAjouteDiagnosticDto dossier, String userConnecte){

        DossierMedical saveDiagnostic = dossierMedicalRepository.findDossierMedicalByPatient_Id(id)
                .orElseThrow(() -> new RuntimeException("Dossier médical introuvable."));

        if (!isUserMedecin()) {
            throw new AccessDeniedException("Seul un médecin peut ajouter un diagnostic.");
        }

        saveDiagnostic.setDiagnostic(dossier.getDiagnostic());
        DossierMedical update = dossierMedicalRepository.save(saveDiagnostic);

        return dossierMedicalMapper.toResponseDto(update);
    }


    public DossierMedicalResponseDto ajouterObservations(long id, DossierMedicalAjouterObservationsDto dossierMedicalAjouterObservationsDto, String userConnecte){

        DossierMedical saveObservations = dossierMedicalRepository.findDossierMedicalByPatient_Id(id)
                .orElseThrow(() -> new RuntimeException("Dossier médical introuvable."));

        if (!isUserMedecin()) {
            throw new AccessDeniedException("Seul un médecin peut ajouter une observation.");
        }

        saveObservations.setObservation(dossierMedicalAjouterObservationsDto.getObservation());
        DossierMedical update = dossierMedicalRepository.save(saveObservations);

        return dossierMedicalMapper.toResponseDto(update);
    }


    public DossierMedicalResponseDto consulterDossierMedical(long id, String userConnecte) {

        DossierMedical dossier = dossierMedicalRepository.findDossierMedicalByPatient_Id(id)
                .orElseThrow(() -> new RuntimeException("Dossier médical introuvable."));

        boolean isMoulDossier = dossier.getPatient().getUser().getUsername().equals(userConnecte);

        if (!isMoulDossier && !isUserMedecin()) {
            throw new AccessDeniedException("Confidentialité: Vous n'êtes pas autorisé à consulter ce dossier médical.");
        }

        return dossierMedicalMapper.toResponseDto(dossier);
    }
}