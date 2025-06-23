package sn.edu.isep.dbe.DocsEtConfig.securities;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class DocsEtConfigSecurityFilter extends OncePerRequestFilter {
private final Logger logger = LoggerFactory.getLogger("MySecurityFilter");
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws SecurityException, IOException, ServletException {
    logger.debug("execution methode diFilterInternal de la classe DoacsEtConfigSecurityFilter");
    logger.info("requete sur url" +request.getRequestURI());
    String userAgent = request.getHeader("User-Agent");
    if (userAgent.contains("win")){
        logger.warn("utilisation de windows:"+userAgent);
    }
    logger.error("requete sur url"+request.getRequestURI());
        List<GrantedAuthority> roles = List.of(
                new SimpleGrantedAuthority("suppMag"),
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("ROLE_ADMIN"));
    SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
            "Abdou Fall", "insa@isepat.edu.sn",roles
    ));

    filterChain.doFilter(request, response);

    }
}
