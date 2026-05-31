package org.example.systemedegestionmedicale.Service;


import org.example.systemedegestionmedicale.Dto.request.MedecinDto;
import org.example.systemedegestionmedicale.Dto.response.MedecinResponseDto;
import org.example.systemedegestionmedicale.Mapper.MedecinMapper;
import org.example.systemedegestionmedicale.Models.Medecin;
import org.example.systemedegestionmedicale.Repository.MedecinRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinService {

    private MedecinRepository medecinRepository;
    private MedecinMapper medecinMapper;

    public MedecinService(MedecinRepository medecinRepository, MedecinMapper medecinMapper){
        this.medecinRepository = medecinRepository;
        this.medecinMapper = medecinMapper;
    }


    public MedecinResponseDto ajouterMedecin(MedecinDto medecinDto){
        Medecin entity = medecinMapper.toEntity(medecinDto);
        Medecin save = medecinRepository.save(entity);
        return medecinMapper.toResponseDto(save);

    }

    public MedecinResponseDto ModifierMedecin(long id, MedecinDto medecinDto){
        Medecin saveId = medecinRepository.findById(id).orElse(null);

        saveId.setNom(medecinDto.getNom());
        saveId.setSpecialite(medecinDto.getSpecialite());
        saveId.setTelephone(medecinDto.getTelephone());
        Medecin update =  medecinRepository.save(saveId);
        return medecinMapper.toResponseDto(update);
    }

    public void supprimerMedecin(long id){
        medecinRepository.deleteById(id);
    }

    public List<MedecinResponseDto> listerMedecins(){
        return medecinMapper.toDtoList(medecinRepository.findAll());
    }

    public Page<MedecinResponseDto> triMedecinParSpecialite(String specialite, int size, int page){
        Pageable pageable = PageRequest.of(size, page);
        Page<Medecin> medecins = medecinRepository.findAllByOrderBySpecialiteDesc(specialite,pageable);
        return medecins.map(medecinMapper::toResponseDto);

    }

    public Page<MedecinResponseDto> rechercheMedecinParSpecialite(String specialite, int page , int size ){
        Pageable pageable = PageRequest.of(page, size);
        Page<Medecin> medecins = medecinRepository.findBySpecialite(specialite, pageable);
        return medecins.map(medecinMapper::toResponseDto);
    }

}
