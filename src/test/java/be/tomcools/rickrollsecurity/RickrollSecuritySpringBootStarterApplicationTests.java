package be.tomcools.rickrollsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(locations = "classpath:test.properties")
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class RickrollSecuritySpringBootStarterApplicationTests {

    @Autowired
    TestRestTemplate template;

    @Test
    void testRedirectForPath() {
        ResponseEntity<String> forEntity = template.getForEntity("/admin", String.class);
        assertThat(forEntity.getStatusCode()).isEqualTo(HttpStatus.FOUND);
    }

    @Test
    void testRedirectForPathMatch() {
        ResponseEntity<String> forEntity = template.getForEntity("/admin/rick-roll", String.class);
        assertThat(forEntity.getStatusCode()).isEqualTo(HttpStatus.FOUND);
    }

    @Test
    void testRedirectForSubPathNoMatch() {
        ResponseEntity<String> forEntity = template.getForEntity("/rick-roll/admin", String.class);
        assertThat(forEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testRedirectForFileExtension() {
        ResponseEntity<String> forEntity = template.getForEntity("/random.php", String.class);
        assertThat(forEntity.getStatusCode()).isEqualTo(HttpStatus.FOUND);
    }

    @Test
    void testNonSetupNotFound() {
        ResponseEntity<String> response = template.exchange("/NOTHING", HttpMethod.GET, null, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

}
