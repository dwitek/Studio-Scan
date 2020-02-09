package pl.dwitek.studioscan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity httpSecurity) {
        return httpSecurity
                .csrf()
                .csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeExchange()
                .pathMatchers(HttpMethod.DELETE).denyAll()
                .pathMatchers("/register", "/login", "/logout").permitAll()
                .anyExchange().authenticated()
                .and()
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
//                .and()
//                .loginPage("/login")
//                .authenticationSuccessHandler(new WebFilterChainServerAuthenticationSuccessHandler())
//                .authenticationFailureHandler((exchange, exception) -> Mono.error(exception))
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint((exchange, exception) -> Mono.error(exception))
//                .accessDeniedHandler((exchange, exception) -> Mono.error(exception))
//                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new CustomPasswordEncoder();
    }
}
