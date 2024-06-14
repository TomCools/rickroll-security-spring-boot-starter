package be.tomcools.rickrollsecurity;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.io.IOException;

@Order(Ordered.HIGHEST_PRECEDENCE)
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
