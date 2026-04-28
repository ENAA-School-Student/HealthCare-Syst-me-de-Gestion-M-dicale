package org.example.systemedegestionmedicale.Controller;


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
}
