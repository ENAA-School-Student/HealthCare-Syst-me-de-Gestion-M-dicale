package org.example.systemedegestionmedicale;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "app.jwt.secret=testSecretKeyForTestingOnlyNotReal12345678",
        "app.jwt.expiration=86400000",
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.cache.type=none",
        "spring.data.redis.host=localhost",
        "spring.data.redis.port=6379"
})
class SystemeDeGestionMedicaleApplicationTests {


    @Test
    void contextLoads() {
    }

}
