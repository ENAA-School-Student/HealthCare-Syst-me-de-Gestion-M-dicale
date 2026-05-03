package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.MedecinDto;
import org.example.systemedegestionmedicale.Dto.response.MedecinResponseDto;
import org.example.systemedegestionmedicale.Service.MedecinService;
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
    public MedecinResponseDto ajouterMedecin(@Valid @RequestBody MedecinDto medecinDto){
        return medecinService.ajouterMedecin(medecinDto);
    }

    @PutMapping("/{id}")
    public MedecinResponseDto ModifierMedecin(@Valid @PathVariable long id, @RequestBody MedecinDto medecinDto){
        return medecinService.ModifierMedecin(id, medecinDto);
    }

    @DeleteMapping("/{id}")
    public void supprimerMedecin(@PathVariable long id){
        medecinService.supprimerMedecin(id);
    }

    @GetMapping
    public List<MedecinResponseDto> listerMedecins(){
        return medecinService.listerMedecins();
    }


}
