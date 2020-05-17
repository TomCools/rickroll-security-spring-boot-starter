package be.tomcools.rickrollsecurity;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RickRollFilter implements Filter {

    private static final String RICKROLL_URL = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
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
            if (requestUri.equals(path)) {
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
        response.sendRedirect(RICKROLL_URL);
    }
}
