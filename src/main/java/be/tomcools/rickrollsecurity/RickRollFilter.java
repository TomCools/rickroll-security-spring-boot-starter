package be.tomcools.rickrollsecurity;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RickRollFilter implements Filter {
    private static final PathMatcher PATH_MATCHER = new AntPathMatcher();

    private final RickRollConfigurationProperties properties;

    public RickRollFilter(RickRollConfigurationProperties properties) {
        this.properties = properties;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestUri = request.getRequestURI();
        for (String path : properties.getPaths()) {
            if (PATH_MATCHER.match(path, requestUri)) {
                rickroll(response);
                return;
            }
        }
        for (String path : properties.getFileExtensions()) {
            if (requestUri.endsWith(path)) {
                rickroll(response);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void rickroll(HttpServletResponse response) throws IOException {
        response.sendRedirect(properties.getVersionUrl());
    }
}
