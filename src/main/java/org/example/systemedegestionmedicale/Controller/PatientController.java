package org.example.systemedegestionmedicale.Controller;


import lombok.RequiredArgsConstructor;
import org.example.systemedegestionmedicale.Dto.PatientDto;
import org.example.systemedegestionmedicale.Service.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public PatientDto ajouterPatient(@RequestBody PatientDto patientDto){
        return patientService.ajouterPatient(patientDto);
    }

    @PutMapping("/{id}")
    public PatientDto modifierPatient(@PathVariable long id, PatientDto patientDto){
        return patientService.modifierPatient(id,patientDto);
    }

    @DeleteMapping("{id}")
    public void supprimerPatient(@PathVariable long id){
        patientService.supprimerPatient(id);
    }

}
