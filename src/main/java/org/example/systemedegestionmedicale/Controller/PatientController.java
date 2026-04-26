package org.example.systemedegestionmedicale.Controller;


import lombok.RequiredArgsConstructor;
import org.example.systemedegestionmedicale.Dto.PatientDto;
import org.example.systemedegestionmedicale.Service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public PatientDto ajouterPatient(@RequestBody PatientDto patientDto){
        return patientService.ajouterPatient(patientDto);
    }
}
