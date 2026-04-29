package org.example.systemedegestionmedicale.serviceTest;

import org.example.systemedegestionmedicale.Dto.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.RendezVousModifierDto;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;
import org.example.systemedegestionmedicale.Mapper.RendezVouMapper;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.example.systemedegestionmedicale.Repository.RendezVousRepository;
import org.example.systemedegestionmedicale.Service.RendezVousService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;


@SpringBootTest
@Transactional
public class RendezVousTest {

    @Autowired
    private RendezVousService rendezVousService;
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private RendezVouMapper rendezVouMapper;
    RendezVousDto rendezVousDto = new RendezVousDto();
   @BeforeEach
    void setUp(){

       rendezVousDto.setDateRendezVous(LocalDate.now());
       rendezVousDto.setStatusRendezVou(StatusRendezVou.en_attend);
       rendezVousDto.setMedecinId(1);
       rendezVousDto.setPatientId(1);

   }

   @Test
    void creerRendezVous(){
       RendezVousDto saveR = rendezVousService.creerRendezVous(rendezVousDto);
       assertNotNull(saveR);
       assertEquals(rendezVousDto.getDateRendezVous(),saveR.getDateRendezVous());

   }

   @Test
    void modifierRendezVous(){
       RendezVousModifierDto rendezVousModifierDto = new RendezVousModifierDto();
       RendezVou rendezVou = rendezVouMapper.toModifier(rendezVousModifierDto);
       rendezVou.setStatusRendezVou(StatusRendezVou.annule);
       rendezVou.setDateRendezVous(LocalDate.now());
       RendezVou rendezVou1 = rendezVousRepository.save(rendezVou);
       rendezVousService.modifierRendezVous(rendezVou.getId(),rendezVousModifierDto);
       assertEquals(rendezVousModifierDto.getStatusRendezVou(), rendezVou1.getStatusRendezVou());
   }

   @Test
    void annulerRendezVous(){
       RendezVou rendezVou = rendezVouMapper.toEntity(rendezVousDto);
       rendezVousRepository.save(rendezVou);
       RendezVousDto dto = rendezVousService.annulerRendezVous(rendezVou.getId());
       assertEquals(rendezVou.getStatusRendezVou(), dto.getStatusRendezVou());
   }

   @Test
    void findPatientById(){
       RendezVou rendezVou = rendezVouMapper.toEntity(rendezVousDto);
       rendezVousService.findPatientById(rendezVou.getId());
       assertTrue(rendezVousRepository.findRendezVouByPatient_Id(rendezVou.getId()).isEmpty());
   }

   @Test
    void findMedecinById(){
       RendezVou rendezVou = rendezVouMapper.toEntity(rendezVousDto);
       rendezVousService.findMedecinById(rendezVou.getId());
       assertTrue(rendezVousRepository.findRendezVouByMedecin_Id(rendezVou.getId()).isEmpty());
   }

}
