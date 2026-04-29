package org.example.systemedegestionmedicale.serviceTest;


import org.example.systemedegestionmedicale.Dto.DossierMedicalAjouteDiagnosticDto;
import org.example.systemedegestionmedicale.Dto.DossierMedicalDto;
import org.example.systemedegestionmedicale.Dto.RendezVousDto;
import org.example.systemedegestionmedicale.Mapper.DossierMedicalMapper;
import org.example.systemedegestionmedicale.Models.DossierMedical;
import org.example.systemedegestionmedicale.Repository.DossierMedicalRepository;
import org.example.systemedegestionmedicale.Service.DossierMedicalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
public class DossierMedicalTest {

    @Autowired
    private DossierMedicalService dossierMedicalService;
    @Autowired
    private DossierMedicalMapper dossierMedicalMapper;
    @Autowired
    private DossierMedicalRepository dossierMedicalRepository;

    DossierMedicalDto dossierMedicalDto = new DossierMedicalDto();
    @BeforeEach
    void setUp(){
        dossierMedicalDto.setDateCreation(LocalDate.now());
        dossierMedicalDto.setDiagnostic("mrid");
        dossierMedicalDto.setObservation("khaso ichrab lma");
        dossierMedicalDto.setMedecinId(1);
        dossierMedicalDto.setPatientId(1);
    }

    @Test
    void CreerDossierMedical(){
        DossierMedicalDto saveD = dossierMedicalService.CreerDossierMedical(dossierMedicalDto);
        assertNotNull(saveD);
        assertEquals(saveD.getDateCreation(), dossierMedicalDto.getDateCreation());
    }

}
