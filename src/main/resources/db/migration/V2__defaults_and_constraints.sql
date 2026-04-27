
ALTER table dossier_medical
    add CONSTRAINT fk_dossier_medical_patient foreign key (patient_id) references patient(id),
    add CONSTRAINT fk_dossier_medical_medecin foreign key (medecin_id) references medecin(id);

ALTER table rendez_vou
    add CONSTRAINT fk_rendezVou_patient foreign key (patient_id) references patient(id),
add CONSTRAINT fk_rendezVou_medecin foreign key (medecin_id) references medecin(id);

ALTER TABLE rendez_vou
    ALTER COLUMN status_rendez_vou SET DEFAULT 'EN_ATTENTE';