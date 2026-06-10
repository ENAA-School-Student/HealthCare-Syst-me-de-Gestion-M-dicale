package org.example.systemedegestionmedicale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SystemeDeGestionMedicaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemeDeGestionMedicaleApplication.class, args);
    }

}
