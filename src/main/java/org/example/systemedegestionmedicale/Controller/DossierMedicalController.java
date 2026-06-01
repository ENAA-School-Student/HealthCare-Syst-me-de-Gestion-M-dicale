package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouteDiagnosticDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouterObservationsDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalDto;
import org.example.systemedegestionmedicale.Dto.response.DossierMedicalResponseDto;
import org.example.systemedegestionmedicale.Service.DossierMedicalService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dossiermedical")
public class DossierMedicalController {

    private final DossierMedicalService dossierMedicalService;

    public DossierMedicalController(DossierMedicalService dossierMedicalService){
        this.dossierMedicalService = dossierMedicalService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public DossierMedicalResponseDto CreerDossierMedical(@Valid @RequestBody DossierMedicalDto dossierMedicalDto){
        return dossierMedicalService.CreerDossierMedical(dossierMedicalDto);
    }

    @PreAuthorize("hasAnyRole('MEDECIN','ADMIN')")
    @PutMapping("/{id}/diagnostic")
    public DossierMedicalResponseDto ajouteDiagnostic(
            @PathVariable long id,
            @Valid @RequestBody DossierMedicalAjouteDiagnosticDto dossierMedicalAjouteDiagnosticDto,
            Authentication authentication) {

        String userConnecte = authentication.getName();

        return dossierMedicalService.ajouterDiagnostic(id, dossierMedicalAjouteDiagnosticDto, userConnecte);
    }

    @PreAuthorize("hasAnyRole('MEDECIN','ADMIN')")
    @PutMapping("/{id}/observation")
    public DossierMedicalResponseDto ajouterObservations(
            @PathVariable long id,
            @Valid @RequestBody DossierMedicalAjouterObservationsDto dossierMedicalAjouterObservationsDto,
            Authentication authentication) {

        String userConnecte = authentication.getName();

        return dossierMedicalService.ajouterObservations(id, dossierMedicalAjouterObservationsDto, userConnecte);
    }

    @PreAuthorize("hasAnyRole('PATIENT', 'MEDECIN', 'ADMIN')")
    @GetMapping("/{id}")
    public DossierMedicalResponseDto consulterDossierMedical(@PathVariable long id, Authentication authentication){

        String userConnecte = authentication.getName();
        return dossierMedicalService.consulterDossierMedical(id, userConnecte);
    }
}