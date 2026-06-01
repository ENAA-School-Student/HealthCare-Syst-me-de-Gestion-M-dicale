package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.MedecinDto;
import org.example.systemedegestionmedicale.Dto.response.MedecinResponseDto;
import org.example.systemedegestionmedicale.Service.MedecinService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecin")
public class MedecinController {

    private final MedecinService medecinService;

    public MedecinController(MedecinService medecinService){
        this.medecinService = medecinService;
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MedecinResponseDto ajouterMedecin(@Valid @RequestBody MedecinDto medecinDto){
        return medecinService.ajouterMedecin(medecinDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MEDECIN')")
    public MedecinResponseDto ModifierMedecin(@Valid @PathVariable long id, @RequestBody MedecinDto medecinDto){
        return medecinService.ModifierMedecin(id, medecinDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void supprimerMedecin(@PathVariable long id){
        medecinService.supprimerMedecin(id);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<MedecinResponseDto> listerMedecins(){
        return medecinService.listerMedecins();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/tri_medecin_par_specialite")
    public Page<MedecinResponseDto> triMedecinParSpecialite(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam String specialite
    ){
      Page<MedecinResponseDto> medecins = medecinService.triMedecinParSpecialite(specialite,page,size);
      return medecins;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/recherche-medecin-par-specialite")
    public Page<MedecinResponseDto> rechercheMedecinParSpecialite(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                  @RequestParam(value = "size", defaultValue = "20") int size,
                                                                  @RequestParam String specialite){
        Page<MedecinResponseDto> medecins = medecinService.rechercheMedecinParSpecialite(specialite,page,size);
        return medecins;
    }




}
