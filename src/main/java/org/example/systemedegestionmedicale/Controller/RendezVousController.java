package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.request.RendezVousModifierDto;
import org.example.systemedegestionmedicale.Dto.response.RendezVouResponseDto;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.example.systemedegestionmedicale.Service.RendezVousService;
import org.example.systemedegestionmedicale.pdf.PdfService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/rendez-vous")
public class RendezVousController {

    private final RendezVousService rendezVousService;
    private final PdfService pdfService;
    public RendezVousController(RendezVousService rendezVousService, PdfService pdfService){
        this.rendezVousService = rendezVousService;
        this.pdfService = pdfService;
    }


    @PreAuthorize("hasAnyRole('ADMIN','PATIENT')")
    @PostMapping
    public RendezVouResponseDto CreerRendezVous(@Valid @RequestBody RendezVousDto rendezVousDto){
        return rendezVousService.creerRendezVous(rendezVousDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public RendezVouResponseDto modifierRendezVous(@Valid @PathVariable long id, @RequestBody RendezVousModifierDto rendezVousDto){
        return rendezVousService.modifierRendezVous(id, rendezVousDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/statut")
    public void annulerRendezVous(@Valid @PathVariable long id){
        rendezVousService.annulerRendezVous(id);
    }

    @PreAuthorize("hasAnyRole('MEDECIN','ADMIN')")
    @GetMapping
    public List<RendezVouResponseDto> listerRendezVous(){
        return rendezVousService.listerRendezVous();
    }

    @PreAuthorize("hasAnyRole('PATIENT', 'ADMIN')")
    @GetMapping("/{id}/patient")
    public List<RendezVouResponseDto> findPatientById(@PathVariable long id){

        List<RendezVouResponseDto> rendevous =  rendezVousService.findPatientById(id);
        return rendevous;
    }

    @PreAuthorize("hasAnyRole('MEDECIN', 'ADMIN')")
    @GetMapping("/{id}/medecin")
    public List<RendezVouResponseDto> findMedecinById(@PathVariable long id, Authentication authentication){

        String userConnecte = authentication.getName();

        return rendezVousService.findMedecinById(id);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/tri-rendez-vous-par-date")
    public Page<RendezVouResponseDto> triRendezVousParDate(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam LocalDate date

            ){
        Page<RendezVouResponseDto> rendezVous = rendezVousService.triRendezVousParDate(date, page,size);
        return rendezVous;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/recherche-rendez-vous-par-statut")
    public Page<RendezVouResponseDto> rechercheRendezVousParStatut(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam StatusRendezVou status
            ){
        Page<RendezVouResponseDto> rendezVous = rendezVousService.rechercheRendezVousParStatut(status, page, size);
        return rendezVous;
    }

    @PreAuthorize("hasAnyRole('ADMIN','MEDECIN','PATIENT')")
    @GetMapping("/pdf/{idPatient}")
    public ResponseEntity<byte[]> downloadPdfPatient(@PathVariable Long idPatient) {
        List<RendezVouResponseDto> rdvs = rendezVousService.findPatientById(idPatient);
        byte[] pdf = pdfService.generateRendezVousPdf(rdvs);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=rendezvous_patient_" + idPatient + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }}
