package be.tomcools.rickrollsecurity;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
