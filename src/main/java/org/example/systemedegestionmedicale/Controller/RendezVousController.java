package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.RendezVousModifierDto;
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
    public RendezVousDto CreerRendezVous(@Valid @RequestBody RendezVousDto rendezVousDto){
        return rendezVousService.creerRendezVous(rendezVousDto);
    }

    @PutMapping("/{id}")
    public RendezVousDto modifierRendezVous(@Valid @PathVariable long id, @RequestBody RendezVousModifierDto rendezVousDto){
        return rendezVousService.modifierRendezVous(id, rendezVousDto);
    }
    @PutMapping("/{id}/statut")
    public void annulerRendezVous(@Valid @PathVariable long id){
        rendezVousService.annulerRendezVous(id);
    }

    @GetMapping
    public List<RendezVousDto> listerRendezVous(){
        return rendezVousService.listerRendezVous();
    }

    @GetMapping("/{id}/patient")
    public List<RendezVousDto> findPatientById(@PathVariable long id){
        return rendezVousService.findPatientById(id);
    }

    @GetMapping("/{id}/medecin")
    public List<RendezVousDto> findMedecinById(@PathVariable long id){
        return rendezVousService.findMedecinById(id);
    }
    
}
