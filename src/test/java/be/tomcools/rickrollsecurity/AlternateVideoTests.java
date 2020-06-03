package be.tomcools.rickrollsecurity;

import static org.assertj.core.api.Assertions.*;

import be.tomcools.rickrollsecurity.RickRollConfigurationProperties.Version;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "rickroll.version=scary-pockets")
class AlternateVideoTests {

    @Autowired
    RickRollConfigurationProperties properties;

    @Test
    void picksUpAlternateVideo() {
        assertThat(properties.getVersionUrl()).isEqualTo(Version.SCARY_POCKETS.url);
    }
}
