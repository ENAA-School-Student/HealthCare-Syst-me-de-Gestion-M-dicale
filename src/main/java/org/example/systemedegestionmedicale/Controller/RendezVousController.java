package org.example.systemedegestionmedicale.Controller;


import lombok.AllArgsConstructor;
import org.example.systemedegestionmedicale.Dto.RendezVousDto;
import org.example.systemedegestionmedicale.Service.RendezVousService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rendez-vous")
public class RendezVousController {

    private RendezVousService rendezVousService;
    public RendezVousController(RendezVousService rendezVousService){
        this.rendezVousService = rendezVousService;
    }

    @PostMapping
    public RendezVousDto CreerRendezVous(@RequestBody RendezVousDto rendezVousDto){
        return rendezVousService.CreerRendezVous(rendezVousDto);
    }
}
