package com.icomfortableworld.jwt.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.icomfortableworld.jwt.JwtProvider;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "JWT 검증 및 인가")
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtProvider jwtProvider;
	private final MemberDetailsServiceImpl userDetailsService;

	public JwtAuthenticationFilter(JwtProvider jwtProvider, MemberDetailsServiceImpl userDetailsService) {
		this.jwtProvider = jwtProvider;
		this.userDetailsService = userDetailsService;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		String token = jwtProvider.getJwtFromHeader(request);

		if (StringUtils.hasText(token)) {

			if (!jwtProvider.validateToken(token)) {
				log.error("Token Error");
				return;
			}

			Claims info = jwtProvider.getUserInfoFromToken(token);

			try {
				setAuthentication(info.getSubject());
			} catch (Exception e) {
				log.error(e.getMessage());
				return;
			}
		}
		filterChain.doFilter(request, response);
	}

	public void setAuthentication(String username) {
		Authentication authentication = createAuthentication(username);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private Authentication createAuthentication(String username) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}
}