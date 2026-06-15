package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouteDiagnosticDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalAjouterObservationsDto;
import org.example.systemedegestionmedicale.Dto.request.DossierMedicalDto;
import org.example.systemedegestionmedicale.Dto.response.DossierMedicalResponseDto;
import org.example.systemedegestionmedicale.Models.DossierMedical;
import org.example.systemedegestionmedicale.Service.DossierMedicalService;
import org.example.systemedegestionmedicale.pdf.PdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dossiermedical")
public class DossierMedicalController {

    private final DossierMedicalService dossierMedicalService;
    private final PdfService pdfService;

    public DossierMedicalController(DossierMedicalService dossierMedicalService, PdfService pdfService){
        this.dossierMedicalService = dossierMedicalService;
        this.pdfService = pdfService;
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
            @Valid @RequestBody DossierMedicalAjouteDiagnosticDto dossierMedicalAjouteDiagnosticDto) {
        return dossierMedicalService.ajouterDiagnostic(id, dossierMedicalAjouteDiagnosticDto);
    }

    @PreAuthorize("hasAnyRole('MEDECIN','ADMIN')")
    @PutMapping("/{id}/observation")
    public DossierMedicalResponseDto ajouterObservations(
            @PathVariable long id,
            @Valid @RequestBody DossierMedicalAjouterObservationsDto dossierMedicalAjouterObservationsDto) {

        return dossierMedicalService.ajouterObservations(id, dossierMedicalAjouterObservationsDto);
    }

    @PreAuthorize("hasAnyRole('PATIENT', 'MEDECIN', 'ADMIN')")
    @GetMapping("/{id}")
    public DossierMedicalResponseDto consulterDossierMedical(@PathVariable long id){
        return dossierMedicalService.consulterDossierMedical(id);
    }

    @PreAuthorize("hasAnyRole('PATIENT','MEDECIN')")
    @GetMapping("/pdf/{id}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) {
        DossierMedicalResponseDto dm = dossierMedicalService.consulterDossierMedical(id);
        byte[] pdf = pdfService.generateDossierMedicalPdf(dm);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=dossier_medical_" + id + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}