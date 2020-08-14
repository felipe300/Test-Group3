package com.desafiolatam.proyect.login.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.desafiolatam.proyect.Util.JwtUtil;
import com.desafiolatam.proyect.login.service.MyUserDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter{
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String SECRET = "mySecretKey";
	
	@Autowired
	private MyUserDetailsService myUserService;
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader(HEADER);
		
		String username = null;
		String jwt = null;
		
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			jwt = authHeader.substring(7);
			username = jwtUtil.extractUserName(jwt);
		}
		if(authHeader != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.myUserService.loadUserByUsername(username);
			if(jwtUtil.validate(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws ServletException, IOException {
//		try {
//			if (existeJWTToken(request, response)) {
//				Claims claims = validateToken(request);
//				if (claims.get("authorities") != null) {
//					setUpSpringAuthentication(claims);
//				} else {
//					SecurityContextHolder.clearContext();
//				}
//			} else {
//					SecurityContextHolder.clearContext();
//			}
//			chain.doFilter(request, response);
//		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
//			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
//			return;
//		}
//	}
//	
//	private Claims validateToken(HttpServletRequest request) {
//		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
//		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
//	}
//	
//	private void setUpSpringAuthentication(Claims claims) {
//		@SuppressWarnings("unchecked")
//		List<String> authorities = (List<String>) claims.get("authorities");
//
//		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
//				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
//		SecurityContextHolder.getContext().setAuthentication(auth);
//	}
//	
//	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
//		String authenticationHeader = request.getHeader(HEADER);
//		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
//			return false;
//		return true;
//	}

}
