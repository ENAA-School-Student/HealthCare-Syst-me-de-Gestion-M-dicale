package org.example.systemedegestionmedicale.Service;


import lombok.AllArgsConstructor;
import org.example.systemedegestionmedicale.Dto.MedecinDto;
import org.example.systemedegestionmedicale.Mapper.MedecinMapper;
import org.example.systemedegestionmedicale.Models.Medecin;
import org.example.systemedegestionmedicale.Repository.MedecinRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedecinService {

    private MedecinRepository medecinRepository;
    private MedecinMapper medecinMapper;


    public MedecinDto ajouterMedecin(MedecinDto medecinDto){
        Medecin entity = medecinMapper.toEntity(medecinDto);
        Medecin save = medecinRepository.save(entity);
        return medecinMapper.toDto(save);

    }

    public MedecinDto ModifierMedecin(long id, MedecinDto medecinDto){
        Medecin entity = medecinMapper.toEntity(medecinDto);
        Medecin saveId = medecinRepository.findById(id).orElse(null);

        saveId.setNom(entity.getNom());
        saveId.setSpecialite(entity.getSpecialite());
        saveId.setEmail(entity.getEmail());
        saveId.setTelephone(entity.getTelephone());
        Medecin update =  medecinRepository.save(saveId);
        return medecinMapper.toDto(update);
    }
}
