package be.tomcools.rickrollsecurity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "rickroll")
public class RickRollConfigurationProperties {
    private List<String> paths;

    public List<String> getPaths() {
        if(paths == null) {
            return new ArrayList<>();
        }
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}
