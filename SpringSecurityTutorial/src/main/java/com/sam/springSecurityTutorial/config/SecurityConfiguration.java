package com.sam.springSecurityTutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	private JwtAuthenticationFilter jwtAuthFilter;
	private AuthenticationProvider authenticationProvider;

	//At startup spring application has to look for SecurityFilterChain
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("")   //Avoid these requests
		.permitAll()
		.anyRequest()  //All other request has to be authenticated
		.authenticated()
		.and()
		.sessionManagement()   // When dont want to store token in session so that every request is authenticated
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);  //Perform before username password authentication filter
		
		return http.build();
	}
}
