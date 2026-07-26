package org.example.systemedegestionmedicale.Service;

import org.example.systemedegestionmedicale.Dto.request.PatientDto;
import org.example.systemedegestionmedicale.Dto.response.PatientResponseDto;
import org.example.systemedegestionmedicale.Mapper.PatientMapper;
import org.example.systemedegestionmedicale.Models.Patient;
import org.example.systemedegestionmedicale.Repository.PatientRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }


    @CacheEvict(value = "PATIENT_CACHE", allEntries = true)
    public PatientResponseDto ajouterPatient(PatientDto patientDto) {
        Patient entity = patientMapper.toEntity(patientDto);
        Patient save = patientRepository.save(entity);
        return patientMapper.toResponseDto(save);
    }

    @CacheEvict(value = "PATIENT_CACHE", allEntries = true)
    public PatientResponseDto modifierPatient(long id, PatientDto patientDto, String userConnecte) {
        Patient saveId = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient introuvable pour l'id " + id));

        if (saveId.getUser() == null || !saveId.getUser().getUsername().equals(userConnecte)) {
            throw new AccessDeniedException("Vous n'êtes pas autorisé à modifier ce profil.");
        }

        saveId.setNom(patientDto.getNom());
        saveId.setPrenom(patientDto.getPrenom());
        saveId.setTelephone(patientDto.getTelephone());
        saveId.setDateNaissance(patientDto.getDateNaissance());

        Patient update = patientRepository.save(saveId);
        return patientMapper.toResponseDto(update);
    }

    @CacheEvict(value = "PATIENT_CACHE", allEntries = true)
    public void supprimerPatient(long id) {
        patientRepository.deleteById(id);
    }


    public List<PatientResponseDto> listerTousLesPatients() {
        return patientMapper.todtolist(patientRepository.findAll());
    }


    @Cacheable(value = "PATIENT_CACHE",
            key = "'patients_page_' + #pageable.pageNumber + '_size_' + #pageable.pageSize + '_sort_' + #pageable.sort.toString()")
    public Page<PatientResponseDto> listerPatients(Pageable pageable) {
        return patientRepository.findAll(pageable).map(patientMapper::toResponseDto);
    }

    public PatientResponseDto consulterPatient(long id, String userConnecte) {

        Patient findPatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid id"));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().toUpperCase().contains("ADMIN"));

        boolean isMonCompte = findPatient.getUser() != null
                && findPatient.getUser().getUsername().equals(userConnecte);

        if (!isMonCompte && !isAdmin) {
            throw new AccessDeniedException("Vous n'êtes pas autorisé à consulter ces données.");
        }

        return patientMapper.toResponseDto(findPatient);
    }

    @Cacheable(value = "PATIENT_CACHE",
            key = "'patients_tri_nom_page_' + #page + '_size_' + #size")
    public Page<PatientResponseDto> triPatientParNom(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Patient> patients = patientRepository.findAllByOrderByNomDesc(pageable);
        return patients.map(patientMapper::toResponseDto);
    }

    public Page<PatientResponseDto> recherchePatientParNom(String nom, int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Patient> patients = patientRepository.findByNom(nom, pageable);
        return patients.map(patientMapper::toResponseDto);
    }
}