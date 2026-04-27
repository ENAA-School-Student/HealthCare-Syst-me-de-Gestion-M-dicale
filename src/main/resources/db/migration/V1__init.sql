create table patient(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom varchar(20) NOT NULL ,
    prenom varchar(20) not null ,
    email varchar(40) unique not null ,
    telephone varchar(10) unique not null ,
    date_naissance date not null
);

create table medecin(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom varchar(20) not null ,
    specialite varchar(20) not null ,
    email varchar(40) unique not null ,
    telephone varchar(10) unique not null
);

create table dossier_medical(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    diagnostic VARCHAR(20) not null ,
    observation varchar(20) not null ,
    date_creation date not null ,
    patient_id BIGINT,
    medecin_id BIGINT
);

create table rendez_vou(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_rendez_vous date not null ,
    status_rendez_vou varchar(50) not null ,
    patient_id BIGINT,
    medecin_id BIGINT
);

