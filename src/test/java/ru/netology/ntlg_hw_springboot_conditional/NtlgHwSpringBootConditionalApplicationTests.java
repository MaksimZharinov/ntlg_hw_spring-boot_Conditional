package ru.netology.ntlg_hw_springboot_conditional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NtlgHwSpringBootConditionalApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    private static final GenericContainer<?> DEV_APP = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    private static final GenericContainer<?> PROD_APP = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        DEV_APP.start();
        PROD_APP.start();
    }

    @Test
    void contextLoadsDev() {
        String expected = "Current profile is dev";
        String result;

        ResponseEntity<String> forEntity = restTemplate.getForEntity(
                "http://localhost:" + DEV_APP.getMappedPort(8080) + "/profile",
                String.class);
        result = forEntity.getBody();

        assertEquals(expected, result);
    }

    @Test
    void contextLoadsProd() {
        String expected = "Current profile is production";
        String result;

        ResponseEntity<String> forEntity = restTemplate.getForEntity(
                "http://localhost:" + PROD_APP.getMappedPort(8081) + "/profile",
                String.class);
        result = forEntity.getBody();

        assertEquals(expected, result);
    }
}
