package sn.edu.isep.dbe.DocsEtConfig.securities;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class DocsEtConfigSecurityFilter extends OncePerRequestFilter {
private final Logger logger = LoggerFactory.getLogger("MySecurityFilter");
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)throws SecurityException, IOException{
    logger.debug("execution methode diFilterInternal de la classe DoacsEtConfigSecurityFilter");
    logger.info("requete sur url" +request.getRequestURI());
    String userAgent = request.getHeader("User-Agent");
    if (userAgent.contains("win")){
        logger.warn("utilisation de windows:"+userAgent);
    }
    logger.error("requete sur url"+request.getRequestURI());

    }
}
