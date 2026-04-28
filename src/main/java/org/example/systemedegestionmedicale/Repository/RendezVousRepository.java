package org.example.systemedegestionmedicale.Repository;

import org.example.systemedegestionmedicale.Models.Patient;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVou, Long> {

    RendezVou findPatientById(long id);

}
