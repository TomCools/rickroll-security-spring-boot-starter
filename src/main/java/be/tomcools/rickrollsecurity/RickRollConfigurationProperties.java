package be.tomcools.rickrollsecurity;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@AutoConfiguration
@ConfigurationProperties(prefix = "rickroll")
public class RickRollConfigurationProperties {

    private List<String> paths;
    private List<String> fileExtensions;
    private Version version = Version.ORIGINAL;

    public List<String> getFileExtensions() {
        if(fileExtensions == null) {
            return new ArrayList<>();
        }
        return fileExtensions;
    }

    public void setFileExtensions(List<String> fileExtensions) {
        this.fileExtensions = fileExtensions;
    }

    public List<String> getPaths() {
        if(paths == null) {
            return new ArrayList<>();
        }
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
    
    void setVersion(Version version) {
        this.version = version;
    }
    
    public String getVersionUrl() {
        return version.url;
    }

    enum Version {

        ORIGINAL("https://www.youtube.com/watch?v=dQw4w9WgXcQ"),
        SCARY_POCKETS("https://www.youtube.com/watch?v=sQnoZUR6fvY");

        final String url;

        private Version(String url) {
            this.url = url;
        }
    }
}
