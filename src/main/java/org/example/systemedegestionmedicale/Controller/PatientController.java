package org.example.systemedegestionmedicale.Controller;

import jakarta.validation.Valid;
import org.example.systemedegestionmedicale.Dto.request.PatientDto;
import org.example.systemedegestionmedicale.Dto.response.PatientResponseDto;
import org.example.systemedegestionmedicale.Service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public PatientResponseDto ajouterPatient(@Valid @RequestBody PatientDto patientDto) {
        return patientService.ajouterPatient(patientDto);
    }

    @PreAuthorize("hasRole('PATIENT')")
    @PutMapping("/{id}")
    public PatientResponseDto modifierPatient(@PathVariable long id,
                                              @Valid @RequestBody PatientDto patientDto,
                                              Authentication authentication) {
        String userConnecte = authentication.getName();
        return patientService.modifierPatient(id, patientDto, userConnecte);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void supprimerPatient(@PathVariable long id) {
        patientService.supprimerPatient(id);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<PatientResponseDto> listerTousLesPatients() {
        return patientService.listerTousLesPatients();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/patient")
    public Page<PatientResponseDto> listerPatients(
            @PageableDefault(page = 0, size = 20, direction = Sort.Direction.ASC) Pageable pageable) {
        return patientService.listerPatients(pageable);
    }

    @PreAuthorize("hasAnyRole('PATIENT', 'ADMIN')")
    @GetMapping("/{id}")
    public PatientResponseDto consulterPatient(@PathVariable long id, Authentication authentication) {
        String userConnecte = authentication.getName();
        return patientService.consulterPatient(id, userConnecte);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/tri")
    public Page<PatientResponseDto> triPatientParNom(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam(value = "sort", defaultValue = "ASC") String sort)
    {
        return patientService.triPatientParNom(size, page, sort);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/recherche-patient-par-nom")
    public Page<PatientResponseDto> recherchePatientParNom(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam String nom) {
        return patientService.recherchePatientParNom(nom, size, page);
    }
}