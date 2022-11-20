package be.tomcools.rickrollsecurity;


import jakarta.servlet.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;


@AutoConfiguration
@ConditionalOnClass(Filter.class)
public class RickRollConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(RickRollConfiguration.class);

    @Autowired
    RickRollConfigurationProperties properties;

    @Bean
    public RickRollFilter filter() {
        LOGGER.info("Rickrolling paths: {}", String.join(", ", properties.getPaths()));
        LOGGER.info("Rickrolling extensions: {}", String.join(", ", properties.getFileExtensions()));
        return new RickRollFilter(properties);
    }

}
