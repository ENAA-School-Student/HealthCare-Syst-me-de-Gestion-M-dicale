package org.example.systemedegestionmedicale;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "app.jwt.secret=testSecretKeyForTestingOnlyNotReal12345678901234",
        "app.jwt.expiration=86400000",
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.flyway.enabled=false",
        "spring.cache.type=none",
        "spring.data.redis.url=redis://localhost:6379",
        "spring.data.redis.host=localhost",
        "spring.data.redis.port=6379"
})
class SystemeDeGestionMedicaleApplicationTests {

    @Test
    void contextLoads() {
    }
}