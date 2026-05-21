package org.example.systemedegestionmedicale.Repository;

import org.example.systemedegestionmedicale.Models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
     Boolean existsByNom(String nom);
     Page<Patient> findAllByOrderByNomDesc(Pageable pageable);
}
