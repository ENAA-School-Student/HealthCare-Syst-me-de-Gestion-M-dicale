package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.request.RendezVousModifierDto;
import org.example.systemedegestionmedicale.Dto.response.RendezVouResponseDto;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;
import org.example.systemedegestionmedicale.Service.RendezVousService;
import org.springframework.data.domain.Page;
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
    public RendezVousController(RendezVousService rendezVousService){
        this.rendezVousService = rendezVousService;
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
    public List<RendezVouResponseDto> findPatientById(@PathVariable long id, Authentication authentication){

        String userConnecte = authentication.getName();

        return rendezVousService.findPatientById(id, userConnecte);
    }

    @PreAuthorize("hasAnyRole('MEDECIN', 'ADMIN')")
    @GetMapping("/{id}/medecin")
    public List<RendezVouResponseDto> findMedecinById(@PathVariable long id, Authentication authentication){

        String userConnecte = authentication.getName();

        return rendezVousService.findMedecinById(id, userConnecte);
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
}
