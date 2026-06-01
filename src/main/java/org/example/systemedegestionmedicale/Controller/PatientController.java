package org.example.systemedegestionmedicale.Controller;


import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.PatientDto;
import org.example.systemedegestionmedicale.Dto.response.PatientResponseDto;
import org.example.systemedegestionmedicale.Service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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

    @PreAuthorize("hasRole('PATIENT')")
    @PutMapping("/{id}")
    public PatientResponseDto modifierPatient(@Valid @PathVariable long id,@RequestBody PatientDto patientDto, Authentication authentication){
        String userConnecte = authentication.getName();
        return patientService.modifierPatient(id,patientDto, userConnecte);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void supprimerPatient(@PathVariable long id){
        patientService.supprimerPatient(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/patient")
    public List<PatientResponseDto> listerPatients(){
      return  patientService.listerPatients();
    }


    @PreAuthorize("hasAnyRole('PATIENT', 'ADMIN')")
    @GetMapping("/{id}")
    public PatientResponseDto consulterPatient(@PathVariable long id, Authentication authentication){

        String userConnecte = authentication.getName();

        return patientService.consulterPatient(id, userConnecte);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/tri-patient-par-nom")
    public Page<PatientResponseDto> triPatientParNom(@RequestParam(value ="page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "20") int size
                                                     ){
        Page<PatientResponseDto> patients = patientService.triPatientParNom(size,page);
        return patients;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/recherche-patient-par-nom")
    public Page<PatientResponseDto> recherchePatientParNom(@RequestParam(value = "page", defaultValue = "0")int page,
                                                           @RequestParam(value = "size", defaultValue = "20")int size,
                                                           @RequestParam String nom){
        Page<PatientResponseDto> patients = patientService.recherchePatientParNom(nom,size, page);
        return patients;
    }

}
