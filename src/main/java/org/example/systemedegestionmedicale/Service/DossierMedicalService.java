package org.example.systemedegestionmedicale.Service;


import org.example.systemedegestionmedicale.Dto.DossierMedicalDto;
import org.example.systemedegestionmedicale.Mapper.DossierMedicalMapper;
import org.example.systemedegestionmedicale.Models.DossierMedical;
import org.example.systemedegestionmedicale.Repository.DossierMedicalRepository;
import org.springframework.stereotype.Service;

@Service
public class DossierMedicalService {

    private DossierMedicalMapper dossierMedicalMapper;
    private DossierMedicalRepository dossierMedicalRepository;

    public DossierMedicalService(DossierMedicalRepository dossierMedicalRepository, DossierMedicalMapper dossierMedicalMapper){
        this.dossierMedicalRepository = dossierMedicalRepository;
        this.dossierMedicalMapper = dossierMedicalMapper;
    }


    public DossierMedicalDto CreerDossierMedical(DossierMedicalDto dossierMedicalDto){
        DossierMedical entity = dossierMedicalMapper.toEntity(dossierMedicalDto);
        DossierMedical saveDossier = dossierMedicalRepository.save(entity);
        return dossierMedicalMapper.toDto(saveDossier);
    }

}
