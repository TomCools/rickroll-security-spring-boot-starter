package be.tomcools.rickrollsecurity;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RickRollFilter implements Filter {

    private List<String> pathsToRedirect;

    public RickRollFilter(List<String> pathsToRedirect) {
        this.pathsToRedirect = pathsToRedirect;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestUri = request.getRequestURI();
        for (String path : pathsToRedirect) {
            if(requestUri.equals(path)) {
                response.sendRedirect("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
