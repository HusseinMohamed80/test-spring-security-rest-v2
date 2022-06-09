package com.example.testspringsecurityrest.security.jwt;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.example.testspringsecurityrest.entity.JwtLogin;
import com.example.testspringsecurityrest.entity.ResponseLogin;
import com.example.testspringsecurityrest.entity.User;
import com.example.testspringsecurityrest.repository.UserRepository;
import com.example.testspringsecurityrest.security.UserPrinciple;

@Service
public class TokenService {
	User user = new User();
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;

	public TokenService(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;

	}

	public Authentication attemptAuthentication(JwtLogin jwtLogin) throws AuthenticationException {

		// Create login token
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				jwtLogin.getUsername(), jwtLogin.getPassword(), new ArrayList<>());

		// Authenticate user
		Authentication auth = authenticationManager.authenticate(authenticationToken);

		return auth;
	}

	public ResponseLogin successfulAuthentication(JwtLogin jwtLogin) throws Exception {
		ResponseLogin responseLogin = new ResponseLogin();
		Authentication authResult = attemptAuthentication(jwtLogin);
		responseLogin.setUsername(jwtLogin.getUsername());
		// Grab principal
		UserPrinciple principal = (UserPrinciple) authResult.getPrincipal();

		// Create JWT Token
		String token = JWT.create().withSubject(principal.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
				.sign(HMAC512(JwtProperties.SECRET.getBytes()));
		User user = userRepository.findByUserName(jwtLogin.getUsername());
		UserPrinciple userPrinciple = new UserPrinciple(user);
		responseLogin.setPassword(userPrinciple.getPassword());
		responseLogin.setRole(userPrinciple.getRole());
		responseLogin.setToken(token);

		return responseLogin;
	}
	 
}
