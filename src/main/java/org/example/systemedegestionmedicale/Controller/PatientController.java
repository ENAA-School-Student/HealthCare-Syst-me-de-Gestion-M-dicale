package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.PatientDto;
import org.example.systemedegestionmedicale.Dto.response.PatientResponseDto;
import org.example.systemedegestionmedicale.Service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping
    public PatientResponseDto ajouterPatient(@Valid @RequestBody PatientDto patientDto){
        return patientService.ajouterPatient(patientDto);
    }

    @PutMapping("/{id}")
    public PatientResponseDto modifierPatient(@Valid @PathVariable long id, PatientDto patientDto){
        return patientService.modifierPatient(id,patientDto);
    }

    @DeleteMapping("/{id}")
    public void supprimerPatient(@PathVariable long id){
        patientService.supprimerPatient(id);
    }

    @GetMapping
    public List<PatientResponseDto> listerPatients(){
      return  patientService.listerPatients();
    }

    @GetMapping("/{id}")
    public PatientResponseDto consulterPatient(@PathVariable long id){
        return patientService.consulterPatient(id);
    }

}
