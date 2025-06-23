package sn.edu.isep.dbe.DocsEtConfig.securities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class DocsConfigSecurity {

    private final DocsEtConfigSecurityFilter docsEtConfigSecurityFilter;

    public DocsConfigSecurity(DocsEtConfigSecurityFilter docsEtConfigSecurityFilter) {
        this.docsEtConfigSecurityFilter = docsEtConfigSecurityFilter;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeRequest)->{
                    authorizeRequest
                            .requestMatchers("/swagger-ui/**").permitAll()
                            .requestMatchers("/v3/api-docs/**").permitAll()
                            .requestMatchers("/auth/**").permitAll()
                            .anyRequest().authenticated();
                })
                .sessionManagement(session->{
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilterBefore(docsEtConfigSecurityFilter, UsernamePasswordAuthenticationFilter.class)
                ;


        return http.build();
    }
}
