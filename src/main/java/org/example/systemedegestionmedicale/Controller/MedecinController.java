package org.example.systemedegestionmedicale.Controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.systemedegestionmedicale.Dto.MedecinDto;
import org.example.systemedegestionmedicale.Service.MedecinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medecin")
@AllArgsConstructor
public class MedecinController {

    private final MedecinService medecinService;


    @PostMapping
    public MedecinDto ajouterMedecin(@RequestBody MedecinDto medecinDto){
        return medecinService.ajouterMedecin(medecinDto);
    }


}
