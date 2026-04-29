package org.example.systemedegestionmedicale.serviceTest;


import org.example.systemedegestionmedicale.Dto.PatientDto;
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
        patient.setTelephone("0607523048");
        patient.setNom("Outla");
        patient.setPrenom("Zakaria");
        patient.setEmail("Zakariaa@gmail.com");
        patient.setDateNaissance(LocalDate.of(1999,10,07));
    }

    @Test
    void ajouterPatient(){
        PatientDto dto = patientService.ajouterPatient(patient);
        assertNotNull(dto);
        assertEquals("Outla",dto.getNom());
    }

    @Test
    void modifierPatient(){
        Patient patient1 = patientMapper.toEntity(patient);
        patient1.setNom("Ait");
        patientRepository.save(patient1);
        PatientDto dto = patientService.modifierPatient(patient1.getId(),patient);
        assertEquals(patient1.getNom(), dto.getNom());
    }

    @Test
    void supprimerPatient(){
        Patient patient2 = patientMapper.toEntity(patient);
        patientService.supprimerPatient(patient2.getId());
        assertTrue(patientRepository.findById(patient2.getId()).isEmpty());
    }

}
