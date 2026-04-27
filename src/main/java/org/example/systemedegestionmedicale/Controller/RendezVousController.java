package org.example.systemedegestionmedicale.Controller;


import org.example.systemedegestionmedicale.Dto.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.RendezVousModifierDto;
import org.example.systemedegestionmedicale.Service.RendezVousService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rendez-vous")
public class RendezVousController {

    private final RendezVousService rendezVousService;
    public RendezVousController(RendezVousService rendezVousService){
        this.rendezVousService = rendezVousService;
    }

    @PostMapping
    public RendezVousDto CreerRendezVous(@RequestBody RendezVousDto rendezVousDto){
        return rendezVousService.creerRendezVous(rendezVousDto);
    }

    @PutMapping("/{id}")
    public RendezVousDto modifierRendezVous(@PathVariable long id, @RequestBody RendezVousModifierDto rendezVousDto){
        return rendezVousService.modifierRendezVous(id, rendezVousDto);
    }
    @PutMapping("/{id}/statut")
    public void annulerRendezVous(@PathVariable long id){
        rendezVousService.annulerRendezVous(id);
    }
}
