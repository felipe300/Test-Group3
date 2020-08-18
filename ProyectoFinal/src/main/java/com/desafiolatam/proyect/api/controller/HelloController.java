package com.desafiolatam.proyect.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafiolatam.proyect.Util.JwtUtil;
import com.desafiolatam.proyect.api.model.AuthRequest;
import com.desafiolatam.proyect.api.model.AuthResponse;

@RestController
public class HelloController {
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtToken;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));	
		} catch (Exception e) {
			throw new Exception("Incorrect Username or Password, from helloController", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		final String jwt = jwtToken.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(jwt));
	}
	
//	private String getJWTToken(String username) {
//		String secretKey = "mySecretKey";
//		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
//		
//		String token = Jwts
//				.builder()
//				.setId("softtekJWT")
//				.setSubject(username)
//				.claim("authorities",
//						grantedAuthorities.stream()
//								.map(GrantedAuthority::getAuthority)
//								.collect(Collectors.toList()))
//								.setIssuedAt(new Date(System.currentTimeMillis()))
//								.setExpiration(new Date(System.currentTimeMillis() + 600000))
//								.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
//
//		return "Pipo " + token;
//	}
}
