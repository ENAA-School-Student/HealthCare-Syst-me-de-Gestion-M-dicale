package org.example.systemedegestionmedicale.serviceTest;


import org.example.systemedegestionmedicale.Dto.request.PatientDto;
import org.example.systemedegestionmedicale.Dto.response.PatientResponseDto;
import org.example.systemedegestionmedicale.Mapper.PatientMapper;
import org.example.systemedegestionmedicale.Models.Patient;
import org.example.systemedegestionmedicale.Repository.PatientRepository;
import org.example.systemedegestionmedicale.Service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@SpringBootTest
@Transactional
public class PatientTest {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
            private PatientRepository patientRepository;

    PatientDto patient = new PatientDto();

    @BeforeEach
    void initialisation(){
        patient.setTelephone("0607523087");
        patient.setNom("Outla");
        patient.setPrenom("Zakaria");
        patient.setEmail("Zakariaa@gmail.com");
        patient.setDateNaissance(LocalDate.of(1999,10,07));
    }

    @Test
    void ajouterPatient(){
        PatientResponseDto dto = patientService.ajouterPatient(patient);
        assertNotNull(dto);
        assertEquals("Outla",dto.getNom());
    }

    @Test
    void modifierPatient(){
        PatientResponseDto saved = patientService.ajouterPatient(patient);
        PatientDto update = new PatientDto();
        update.setNom("Ait");
        PatientResponseDto dto = patientService.modifierPatient(saved.getId(),update);
        assertEquals("Ait", dto.getNom());
    }

    @Test
    void supprimerPatient(){
        PatientResponseDto saved = patientService.ajouterPatient(patient);
        patientService.supprimerPatient(saved.getId());
        assertTrue(patientRepository.findById(saved.getId()).isEmpty());
    }

}
