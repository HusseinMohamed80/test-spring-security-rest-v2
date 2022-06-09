package com.example.testspringsecurityrest.entity;

import java.util.List;

public class ResponseLogin {
	private String token;
	private String username;
	private String Password;
	private List<Role> role;

	public ResponseLogin() {

	}

	public ResponseLogin(String token, String username, String password) {

		this.token = token;
		this.username = username;
		Password = password;

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

}