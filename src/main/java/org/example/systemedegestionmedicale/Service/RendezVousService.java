package org.example.systemedegestionmedicale.Service;


import lombok.AllArgsConstructor;
import org.example.systemedegestionmedicale.Dto.RendezVousDto;
import org.example.systemedegestionmedicale.Dto.RendezVousModifierDto;
import org.example.systemedegestionmedicale.Enums.StatusRendezVou;
import org.example.systemedegestionmedicale.Mapper.RendezVouMapper;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.example.systemedegestionmedicale.Repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousService {

    private RendezVousRepository rendezVousRepository;
    private RendezVouMapper rendezVouMapper;

    public RendezVousService(RendezVousRepository rendezVousRepository, RendezVouMapper rendezVouMapper){
        this.rendezVousRepository = rendezVousRepository;
        this.rendezVouMapper = rendezVouMapper;
    }


    public RendezVousDto creerRendezVous(RendezVousDto rendezVousDto){
        RendezVou rendezVou = rendezVouMapper.toEntity(rendezVousDto);
        RendezVou saveRendezVou = rendezVousRepository.save(rendezVou);
        return rendezVouMapper.toDto(saveRendezVou);
    }

    public RendezVousDto modifierRendezVous(long id, RendezVousModifierDto RendezVousModifierDto){
        RendezVou rendezVou = rendezVouMapper.toModifier(RendezVousModifierDto);
        RendezVou saveRendezVou = rendezVousRepository.findById(id).orElse(null);

        saveRendezVou.setDateRendezVous(rendezVou.getDateRendezVous());
        saveRendezVou.setStatusRendezVou(rendezVou.getStatusRendezVou());

        RendezVou update = rendezVousRepository.save(saveRendezVou);
        return rendezVouMapper.toDto(update);
    }

    public RendezVousDto annulerRendezVous(long id){
        RendezVou findRendezVous = rendezVousRepository.findById(id).orElse(null);
         findRendezVous.setStatusRendezVou(StatusRendezVou.annule);
         RendezVou saveRendezVou = rendezVousRepository.save(findRendezVous);
         return rendezVouMapper.toDto(saveRendezVou);
    }

    public List<RendezVousDto> listerRendezVous(){
        return rendezVouMapper.toDtoList(rendezVousRepository.findAll());
    }

    public RendezVousDto findPatientById(long id){
        RendezVou findPatient = rendezVousRepository.findPatientById(id);
        return rendezVouMapper.toDto(findPatient);
    }

}
