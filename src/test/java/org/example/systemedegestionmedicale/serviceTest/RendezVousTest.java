package org.example.systemedegestionmedicale.serviceTest;

import org.example.systemedegestionmedicale.Dto.request.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.request.RendezVousModifierDto;
import org.example.systemedegestionmedicale.Dto.response.RendezVouResponseDto;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;
import org.example.systemedegestionmedicale.Mapper.RendezVouMapper;
import org.example.systemedegestionmedicale.Models.Medecin;
import org.example.systemedegestionmedicale.Models.Patient;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.example.systemedegestionmedicale.Repository.MedecinRepository;
import org.example.systemedegestionmedicale.Repository.PatientRepository;
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
    private PatientRepository patientRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    RendezVousDto rendezVousDto = new RendezVousDto();
   @BeforeEach
    void setUp(){

       Patient patient = new Patient();
       patient.setNom("outla");
       patient.setPrenom("zakaria");
       patient.setEmail("zakaria@gmail.com");
       patient.setTelephone("0608095241");
       patient.setDateNaissance(LocalDate.of(1999,07,10));
       patient = patientRepository.save(patient);

       Medecin medecin = new Medecin();
       medecin.setNom("dr. zakaria");
       medecin.setEmail("zakaria@gmail.com");
       medecin.setSpecialite("dentaire");
       medecin.setTelephone("0608074120");
       medecin = medecinRepository.save(medecin);

       rendezVousDto.setDateRendezVous(LocalDate.now());
       rendezVousDto.setStatusRendezVou(StatusRendezVou.en_attend);
       rendezVousDto.setMedecinId(medecin.getId());
       rendezVousDto.setPatientId(patient.getId());

   }

   @Test
    void creerRendezVous(){
       RendezVouResponseDto saveR = rendezVousService.creerRendezVous(rendezVousDto);
       assertNotNull(saveR);
       assertEquals(rendezVousDto.getDateRendezVous(),saveR.getDateRendezVous());

   }

   @Test
    void modifierRendezVous(){
       RendezVouResponseDto saveId = rendezVousService.creerRendezVous(rendezVousDto);
       RendezVousModifierDto modifi = new RendezVousModifierDto();
       modifi.setStatusRendezVou(StatusRendezVou.annule);
       RendezVouResponseDto update = rendezVousService.modifierRendezVous(saveId.getId(), modifi);
       assertEquals(StatusRendezVou.annule, update.getStatusRendezVou());
   }

   @Test
    void annulerRendezVous(){
       RendezVouResponseDto save = rendezVousService.creerRendezVous(rendezVousDto);
       RendezVouResponseDto dto = rendezVousService.annulerRendezVous(save.getId());
       assertEquals(StatusRendezVou.annule, dto.getStatusRendezVou());

   }

   @Test
    void findPatientById(){
       RendezVouResponseDto save = rendezVousService.creerRendezVous(rendezVousDto);
       rendezVousService.findPatientById(save.getId());
       assertTrue(rendezVousRepository.findRendezVouByPatient_Id(save.getId()).isEmpty());
   }

   @Test
    void findMedecinById(){
       RendezVouResponseDto save = rendezVousService.creerRendezVous(rendezVousDto);
       rendezVousService.findMedecinById(save.getId());
       assertTrue(rendezVousRepository.findRendezVouByMedecin_Id(save.getId()).isEmpty());
   }

}
