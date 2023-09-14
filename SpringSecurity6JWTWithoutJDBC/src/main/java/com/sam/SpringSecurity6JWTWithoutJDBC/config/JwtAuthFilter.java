package com.sam.SpringSecurity6JWTWithoutJDBC.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sam.SpringSecurity6JWTWithoutJDBC.dao.UserDao;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader("Authorization");
		final String userEmail;
		final String jwtToken;
		
		if(authHeader==null	|| !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		jwtToken=authHeader.substring(7);
		userEmail=jwtUtils.extractUsername(jwtToken);
		
		if(userEmail !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails=userDao.findUserByEmail(userEmail);
			final boolean isTokenValid=jwtUtils.isTokenValid(jwtToken, userDetails);
			if(isTokenValid) {
				UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
