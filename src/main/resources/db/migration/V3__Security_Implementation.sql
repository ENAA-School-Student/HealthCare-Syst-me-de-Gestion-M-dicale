CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL
);

ALTER TABLE patient DROP COLUMN email;
ALTER TABLE patient ADD COLUMN user_id BIGINT UNIQUE;
ALTER TABLE patient ADD CONSTRAINT fk_patient_user FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE medecin DROP COLUMN email;
ALTER TABLE medecin ADD COLUMN user_id BIGINT UNIQUE;
ALTER TABLE medecin ADD CONSTRAINT fk_medecin_user FOREIGN KEY (user_id) REFERENCES users(id);