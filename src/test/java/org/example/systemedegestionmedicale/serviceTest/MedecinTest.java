package org.example.systemedegestionmedicale.serviceTest;


import org.example.systemedegestionmedicale.Dto.request.MedecinDto;
import org.example.systemedegestionmedicale.Dto.response.MedecinResponseDto;
import org.example.systemedegestionmedicale.Mapper.MedecinMapper;
import org.example.systemedegestionmedicale.Models.Medecin;
import org.example.systemedegestionmedicale.Repository.MedecinRepository;
import org.example.systemedegestionmedicale.Service.MedecinService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MedecinTest {

    @Autowired
    private MedecinService medecinService;
    @Autowired
    private MedecinMapper medecinMapper;
    @Autowired
    private MedecinRepository medecinRepository;

    MedecinDto medecinDto = new MedecinDto();

    @BeforeEach
    void initialisation(){
        medecinDto.setNom("Outla");
        medecinDto.setEmail("zakariaaa@exmple.com");
        medecinDto.setSpecialite("dr");
        medecinDto.setTelephone("0607834756");
    }

    @Test
    void ajouterMedecin(){
        MedecinResponseDto medecinDto1 = medecinService.ajouterMedecin(medecinDto);
        assertNotNull(medecinDto1);
        assertEquals(medecinDto.getEmail(), medecinDto1.getEmail());
    }

    @Test
    void ModifierMedecin(){
        MedecinResponseDto medecinId = medecinService.ajouterMedecin(medecinDto);
        MedecinDto update = new  MedecinDto();
        update.setNom("Zakaria");
        MedecinResponseDto medecinDtoM = medecinService.ModifierMedecin(medecinId.getId(),update );
        assertEquals("Zakaria", medecinDtoM.getNom());

    }

    @Test
    void supprimerMedecin(){
        MedecinResponseDto save = medecinService.ajouterMedecin(medecinDto);
        medecinService.supprimerMedecin(save.getId());
        assertTrue(medecinRepository.findById(save.getId()).isEmpty());
    }
}
