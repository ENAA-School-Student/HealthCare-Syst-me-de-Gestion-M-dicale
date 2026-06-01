package org.example.systemedegestionmedicale.Repository;

import org.example.systemedegestionmedicale.Models.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {

    Optional<DossierMedical> findDossierMedicalByPatient_Id(long idPatient);
}
