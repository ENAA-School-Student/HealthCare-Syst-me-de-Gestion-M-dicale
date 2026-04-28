package org.example.systemedegestionmedicale.Controller;


import org.example.systemedegestionmedicale.Dto.DossierMedicalAjouteDiagnosticDto;
import org.example.systemedegestionmedicale.Dto.DossierMedicalAjouterObservationsDto;
import org.example.systemedegestionmedicale.Dto.DossierMedicalDto;
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
    public DossierMedicalDto CreerDossierMedical(@RequestBody DossierMedicalDto dossierMedicalDto){
        return dossierMedicalService.CreerDossierMedical(dossierMedicalDto);
    }

    @PutMapping("/{id}/diagnostic")
    public DossierMedicalDto ajouteDiagnostic(@PathVariable long id, @RequestBody DossierMedicalAjouteDiagnosticDto dossierMedicalAjouteDiagnosticDto){
        return dossierMedicalService.ajouterDiagnostic(id, dossierMedicalAjouteDiagnosticDto);
    }

    @PutMapping("/{id}/observation")
    public DossierMedicalDto ajouterObservations(@PathVariable long id, @RequestBody DossierMedicalAjouterObservationsDto dossierMedicalAjouterObservationsDto){
        return dossierMedicalService.ajouterObservations(id, dossierMedicalAjouterObservationsDto);
    }
}
