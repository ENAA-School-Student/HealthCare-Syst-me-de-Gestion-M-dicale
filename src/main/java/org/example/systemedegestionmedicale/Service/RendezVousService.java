package org.example.systemedegestionmedicale.Service;



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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class RendezVousService {

    private RendezVousRepository rendezVousRepository;
    private RendezVouMapper rendezVouMapper;
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;

    public RendezVousService(RendezVousRepository rendezVousRepository, RendezVouMapper rendezVouMapper, PatientRepository patientRepository, MedecinRepository medecinRepository){
        this.rendezVousRepository = rendezVousRepository;
        this.rendezVouMapper = rendezVouMapper;
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
    }


    public RendezVouResponseDto creerRendezVous(RendezVousDto rendezVousDto){

       if(!patientRepository.existsById(rendezVousDto.getPatientId())){
           throw new RuntimeException("patinet ne exite pas");
       }

        RendezVou rendezVou = rendezVouMapper.toEntity(rendezVousDto);
        RendezVou saveRendezVou = rendezVousRepository.save(rendezVou);
        return rendezVouMapper.toResponseDto(saveRendezVou);
    }

    public RendezVouResponseDto modifierRendezVous(long id, RendezVousModifierDto rendezVousModifierDto){
        RendezVou saveRendezVou = rendezVousRepository.findById(id).orElse(null);

        saveRendezVou.setDateRendezVous(rendezVousModifierDto.getDateRendezVous());
        saveRendezVou.setStatusRendezVou(rendezVousModifierDto.getStatusRendezVou());

        RendezVou update = rendezVousRepository.save(saveRendezVou);
        return rendezVouMapper.toResponseDto(update);
    }


    public RendezVouResponseDto annulerRendezVous(long id){
        RendezVou findRendezVous = rendezVousRepository.findById(id).orElse(null);
         findRendezVous.setStatusRendezVou(StatusRendezVou.ANNULE);
         RendezVou saveRendezVou = rendezVousRepository.save(findRendezVous);
         return rendezVouMapper.toResponseDto(saveRendezVou);
    }

    public List<RendezVouResponseDto> listerRendezVous(){
        return rendezVouMapper.toDtoList(rendezVousRepository.findAll());
    }

    public List<RendezVouResponseDto> findPatientById(long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Patient b had l'ID ma-kaynch"));

        List<RendezVou> lesRendezVous = rendezVousRepository.findRendezVouByPatient_Id(patient.getId());
        return rendezVouMapper.toDtoList(lesRendezVous);


    }

    public List<RendezVouResponseDto> findMedecinById(long id) {

        Medecin medecin = medecinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medecin b had l'ID ma-kaynch"));

        List<RendezVou> lesRendezVous = rendezVousRepository.findRendezVouByMedecin_Id(medecin.getId());

        return rendezVouMapper.toDtoList(lesRendezVous);
    }

    public Page<RendezVouResponseDto> triRendezVousParDate(LocalDate date ,int size, int page){
        Pageable pageable = PageRequest.of(size, page);
        Page<RendezVou> rendezVous = rendezVousRepository.findAllByOrderByDateRendezVousDesc(date, pageable);
        return rendezVous.map(rendezVouMapper::toResponseDto);
    }

    public Page<RendezVouResponseDto> rechercheRendezVousParStatut(StatusRendezVou status, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<RendezVou> rendezVous = rendezVousRepository.findByStatusRendezVou(status, pageable);
        return rendezVous.map(rendezVouMapper::toResponseDto);
    }



}
