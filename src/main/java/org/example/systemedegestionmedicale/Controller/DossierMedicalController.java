package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouteDiagnosticDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouterObservationsDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalDto;
import org.example.systemedegestionmedicale.Dto.response.DossierMedicalResponseDto;
import org.example.systemedegestionmedicale.Service.DossierMedicalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dossiermedical")
public class DossierMedicalController {

    private final DossierMedicalService dossierMedicalService;

    public DossierMedicalController(DossierMedicalService dossierMedicalService){
        this.dossierMedicalService = dossierMedicalService;
    }

    @PostMapping
    public DossierMedicalResponseDto CreerDossierMedical(@Valid @RequestBody DossierMedicalDto dossierMedicalDto){
        return dossierMedicalService.CreerDossierMedical(dossierMedicalDto);
    }

    @PutMapping("/{id}/diagnostic")
    public DossierMedicalResponseDto ajouteDiagnostic(@Valid @PathVariable long id, @RequestBody DossierMedicalAjouteDiagnosticDto dossierMedicalAjouteDiagnosticDto){
        return dossierMedicalService.ajouterDiagnostic(id, dossierMedicalAjouteDiagnosticDto);
    }

    @PutMapping("/{id}/observation")
    public DossierMedicalResponseDto ajouterObservations(@Valid @PathVariable long id, @RequestBody DossierMedicalAjouterObservationsDto dossierMedicalAjouterObservationsDto){
        return dossierMedicalService.ajouterObservations(id, dossierMedicalAjouterObservationsDto);
    }
    @GetMapping("{id}")
    public DossierMedicalResponseDto ConsulterDossierMedical(@PathVariable long id){
        return dossierMedicalService.ConsulterDossierMedical(id);
    }
}
