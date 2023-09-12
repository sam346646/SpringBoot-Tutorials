package com.sam.SpringWithDTOAndImpl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user=User
				.withDefaultPasswordEncoder()
				.username("user")
				.password("pass")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests((auth) -> auth
			.requestMatchers("/employee/all","/employee/byId/*","/employee/byName/*").permitAll()
			.requestMatchers("/employee/delete/*").hasRole("USER")
			.anyRequest().authenticated())
		.formLogin();
		
		return http.build();
	}
}
