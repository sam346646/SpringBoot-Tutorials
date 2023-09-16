//Adding jwt authentication
package com.sam.backend.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter	 {
	
	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;

	public JwtAuthFilter(UserAuthenticationProvider userAuthenticationProvider2) {
		this.userAuthenticationProvider=userAuthenticationProvider2;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String authHeader= request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if(authHeader != null) {
			String[] elements= authHeader.split(" ");
			
			if(elements.length==2 && "Bearer".equals(elements[0])) {
				try {
					SecurityContextHolder.getContext().setAuthentication(userAuthenticationProvider.validateToken(elements[1]));
				} catch (RuntimeException e) {
					SecurityContextHolder.clearContext();
					throw e;
				}
				
			}
		}
		filterChain.doFilter(request, response);
	}

}
