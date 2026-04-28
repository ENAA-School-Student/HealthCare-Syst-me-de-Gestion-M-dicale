package org.example.systemedegestionmedicale.Repository;

import org.example.systemedegestionmedicale.Models.Patient;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVou, Long> {

    List<RendezVou> findRendezVouByPatient_Id(long id);
    List<RendezVou> findRendezVouByMedecin_Id(long id);

}
