package be.tomcools.rickrollsecurity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.List;

@Configuration
@ConditionalOnClass(Filter.class)
public class RickRollConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(RickRollConfiguration.class);

    @Autowired
    RickRollConfigurationProperties properties;

    @Bean
    public RickRollFilter filter() {
        List<String> paths = properties.getPaths();
        LOGGER.info("Rickrolling paths: {}", String.join(", ", paths));
        return new RickRollFilter(paths);
    }

}
