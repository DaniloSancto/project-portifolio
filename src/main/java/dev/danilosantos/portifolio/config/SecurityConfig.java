package dev.danilosantos.portifolio.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	public static final String SIGNUP_URL = "/auth/sign-up";
	public static final String SIGNIN_URL = "/auth/sign-in";
	

	public static final String USER_URL = "/**";

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		List<String> permitAllEndpointList = Arrays.asList(SIGNUP_URL, SIGNIN_URL, USER_URL);

		http.cors().and().csrf().disable()
				.authorizeHttpRequests(expressionInterceptUrlRegistry -> expressionInterceptUrlRegistry
						.requestMatchers(permitAllEndpointList.toArray(new String[permitAllEndpointList.size()]))
						.permitAll().anyRequest().authenticated())
				.oauth2ResourceServer().jwt();
		return http.build();
	}
}
