package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.request.RendezVousModifierDto;
import org.example.systemedegestionmedicale.Dto.response.RendezVouResponseDto;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;
import org.example.systemedegestionmedicale.Service.RendezVousService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/rendez-vous")
public class RendezVousController {

    private final RendezVousService rendezVousService;
    public RendezVousController(RendezVousService rendezVousService){
        this.rendezVousService = rendezVousService;
    }

    @PostMapping
    public RendezVouResponseDto CreerRendezVous(@Valid @RequestBody RendezVousDto rendezVousDto){
        return rendezVousService.creerRendezVous(rendezVousDto);
    }

    @PutMapping("/{id}")
    public RendezVouResponseDto modifierRendezVous(@Valid @PathVariable long id, @RequestBody RendezVousModifierDto rendezVousDto){
        return rendezVousService.modifierRendezVous(id, rendezVousDto);
    }
    @PutMapping("/{id}/statut")
    public void annulerRendezVous(@Valid @PathVariable long id){
        rendezVousService.annulerRendezVous(id);
    }

    @PreAuthorize("hasRole('MEDECIN')")
    @GetMapping
    public List<RendezVouResponseDto> listerRendezVous(){
        return rendezVousService.listerRendezVous();
    }

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/{id}/patient")
    public List<RendezVouResponseDto> findPatientById(@PathVariable long id){
        return rendezVousService.findPatientById(id);
    }

    @GetMapping("/{id}/medecin")
    public List<RendezVouResponseDto> findMedecinById(@PathVariable long id){
        return rendezVousService.findMedecinById(id);
    }

    @GetMapping("/tri-rendez-vous-par-date")
    public Page<RendezVouResponseDto> triRendezVousParDate(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam LocalDate date

            ){
        Page<RendezVouResponseDto> rendezVous = rendezVousService.triRendezVousParDate(date, page,size);
        return rendezVous;
    }

    @GetMapping("/recherche-rendez-vous-par-statut")
    public Page<RendezVouResponseDto> rechercheRendezVousParStatut(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam StatusRendezVou status
            ){
        Page<RendezVouResponseDto> rendezVous = rendezVousService.rechercheRendezVousParStatut(status, page, size);
        return rendezVous;
    }
}
