package com.example.testspringsecurityrest.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.example.testspringsecurityrest.entity.JwtLogin;
import com.example.testspringsecurityrest.entity.ResponseLogin;
import com.example.testspringsecurityrest.security.jwt.TokenService;

@RestController
@RequestMapping("/")
public class LoginController {
	@Autowired
	private TokenService tokenService;
	JwtLogin jwtLogin = new JwtLogin();
 

	@PostMapping("/signup")
	public ResponseLogin loginPage(@RequestBody JwtLogin jwtLogin) throws Exception {
		try {
			// Get Token in body
			this.jwtLogin = jwtLogin;
			return tokenService.successfulAuthentication(jwtLogin);
		} catch (SQLException sqlEx) {

			System.out.println("Error In Sql");

		} catch (Exception e) {
			System.out.println("Error" +e);

		}
		return null;
	}

	@GetMapping("/profile")
	public String getAllUser() throws Exception {
		try {
		String name = jwtLogin.getUsername();
		return name.substring(0, 1).toUpperCase() + name.substring(1) + " Profile";
	  
 

	} 
		catch(JWTDecodeException ex) {
			System.out.println("error in json format");
			
		}
		catch (Exception e) {
		System.out.println("Error");

	}
	return null;
	}
}
