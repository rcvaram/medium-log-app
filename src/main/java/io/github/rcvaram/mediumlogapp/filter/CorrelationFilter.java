package io.github.rcvaram.mediumlogapp.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

import static org.springframework.util.StringUtils.hasText;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorrelationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String correlationId = "correlationId";
        try {
            String header = request.getHeader("correlationId");
            if (hasText(header)) {
                MDC.put(correlationId, header.trim());
            } else {
                MDC.put(correlationId, UUID.randomUUID().toString());
            }
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(correlationId);
        }

    }
}
