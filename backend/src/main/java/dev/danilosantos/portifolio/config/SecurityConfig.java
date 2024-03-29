package dev.danilosantos.portifolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private JwtAuthenticationFilter jwtAuthFilter;	
	private AuthenticationProvider authenticationProvider;	
	private LogoutHandler logoutHandler;
	
	public SecurityConfig (JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider,LogoutHandler logoutHandler) {
		this.jwtAuthFilter = jwtAuthFilter;
		this.authenticationProvider = authenticationProvider;
		this.logoutHandler = logoutHandler;
	}
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
    	.csrf()
    	.disable()
    	.authorizeHttpRequests()
    	.requestMatchers("/auth/**", "/users/**")
    	.permitAll()
    	.requestMatchers(HttpMethod.GET, "/posts/**")
    	.permitAll()
    	.anyRequest()
    	.authenticated()
    	.and()
    	.sessionManagement()
    	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	.and()
    	.authenticationProvider(authenticationProvider)
    	.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
    	.logout()
    	.logoutUrl("/auth/logout")
    	.addLogoutHandler(logoutHandler)
    	.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
    	;
    	
    	return http.build();
    }
}