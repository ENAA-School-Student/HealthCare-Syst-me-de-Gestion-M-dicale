package org.example.systemedegestionmedicale.Service;


import lombok.AllArgsConstructor;
import org.example.systemedegestionmedicale.Dto.RendezVousDto;
import org.example.systemedegestionmedicale.Mapper.RendezVouMapper;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.example.systemedegestionmedicale.Repository.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
public class RendezVousService {

    private RendezVousRepository rendezVousRepository;
    private RendezVouMapper rendezVouMapper;

    public RendezVousService(RendezVousRepository rendezVousRepository, RendezVouMapper rendezVouMapper){
        this.rendezVousRepository = rendezVousRepository;
        this.rendezVouMapper = rendezVouMapper;
    }


    public RendezVousDto CreerRendezVous(RendezVousDto rendezVousDto){
        RendezVou rendezVou = rendezVouMapper.toEntity(rendezVousDto);
        RendezVou saveRendezVou = rendezVousRepository.save(rendezVou);
        return rendezVouMapper.toDto(saveRendezVou);
    }
}
