package org.example.systemedegestionmedicale.Repository;

import org.example.systemedegestionmedicale.Enums.StatusRendezVou;
import org.example.systemedegestionmedicale.Models.RendezVou;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVou, Long> {

    Page<RendezVou> findRendezVouByPatient_Id(long id,Pageable pageable);
    List<RendezVou> findRendezVouByMedecin_Id(long id);


    Page<RendezVou> findAllByOrderByDateRendezVousDesc(LocalDate date, Pageable pageable);

    Page<RendezVou> findByStatusRendezVou(StatusRendezVou status, Pageable pageable);


}
