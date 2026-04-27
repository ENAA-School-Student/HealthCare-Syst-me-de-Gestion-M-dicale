package org.example.systemedegestionmedicale.Controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.systemedegestionmedicale.Dto.MedecinDto;
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
    public MedecinDto ajouterMedecin(@RequestBody MedecinDto medecinDto){
        return medecinService.ajouterMedecin(medecinDto);
    }

    @PutMapping("/{id}")
    public MedecinDto ModifierMedecin(@PathVariable long id, @RequestBody MedecinDto medecinDto){
        return medecinService.ModifierMedecin(id, medecinDto);
    }

    @DeleteMapping("/{id}")
    public void supprimerMedecin(@PathVariable long id){
        medecinService.supprimerMedecin(id);
    }

    @GetMapping
    public List<MedecinDto> listerMedecins(){
        return medecinService.listerMedecins();
    }


}
