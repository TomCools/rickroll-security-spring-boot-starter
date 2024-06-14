package be.tomcools.rickrollsecurity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        test("/test-path", true);
    }

    @Test
    void testRedirectForSecuredPath() {
        test("/test-path-secured", true);
    }

    @Test
    void testRedirectForPathSubdirectoryMatch() {
        test("/test-path/rick-roll", true);
    }

    @Test
    void testRedirectForSubPathNoMatch() {
        test("/rick-roll/test-path", false);
    }

    @Test
    void testRedirectForFileExtension() {
        test("/extension.php", true);
    }

    @Test
    void testRedirectForFileExtensionSecuredPath() {
        test("/secured/extension.php", true);
    }

    @Test
    void testNonSetupNotFound() {
        test("/UNKNOWN_PATH", false);
    }

    private void test(String path, boolean rickRolled) {
        ResponseEntity<String> forEntity = template.getForEntity(path, String.class);

        assertThat(forEntity.getStatusCode().equals(HttpStatus.FOUND))
                .withFailMessage("Path %s resulted in unexpected result %s".formatted(path, forEntity))
                .isEqualTo(rickRolled);
    }
}
