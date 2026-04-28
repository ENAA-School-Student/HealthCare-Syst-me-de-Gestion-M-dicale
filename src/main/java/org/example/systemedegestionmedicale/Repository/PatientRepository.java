package org.example.systemedegestionmedicale.Repository;

import org.example.systemedegestionmedicale.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
