//Handling security endpoints
package com.sam.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig{
	
	@Autowired
	private UserAuthentcationEntryPoint userAuthentcationEntryPoint;
	
	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf((c) -> c.disable())
		.exceptionHandling((e) -> e.authenticationEntryPoint(userAuthentcationEntryPoint))
		.authorizeHttpRequests((auth) -> auth
		.requestMatchers(HttpMethod.POST,"/login","/register").permitAll()
		.anyRequest().authenticated())
		.sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(new JwtAuthFilter(userAuthenticationProvider), BasicAuthenticationFilter.class);
		
		return http.build();		
	}
}
