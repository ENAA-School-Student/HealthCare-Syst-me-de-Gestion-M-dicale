package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.request.RendezVousModifierDto;
import org.example.systemedegestionmedicale.Dto.response.RendezVouResponseDto;
import org.example.systemedegestionmedicale.Service.RendezVousService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<RendezVouResponseDto> listerRendezVous(){
        return rendezVousService.listerRendezVous();
    }

    @GetMapping("/{id}/patient")
    public List<RendezVouResponseDto> findPatientById(@PathVariable long id){
        return rendezVousService.findPatientById(id);
    }

    @GetMapping("/{id}/medecin")
    public List<RendezVouResponseDto> findMedecinById(@PathVariable long id){
        return rendezVousService.findMedecinById(id);
    }
    
}
