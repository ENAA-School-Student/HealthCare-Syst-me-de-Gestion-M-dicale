package org.example.systemedegestionmedicale.Repository;

import org.example.systemedegestionmedicale.Models.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {

    DossierMedical findDossierMedicalByPatient_Id(long patientId);
}
