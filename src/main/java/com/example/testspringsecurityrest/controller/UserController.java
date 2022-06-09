package com.example.testspringsecurityrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testspringsecurityrest.entity.User;

import com.example.testspringsecurityrest.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/add-user")
	public User Add(@RequestBody User user) {
		
		try {
			user.setId(0);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userService.AddUser(user);
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@PutMapping("/update-user")
	public User update(@RequestBody User user) {
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userService.AddUser(user);
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@GetMapping("/select-all-user")
	public List<User> getAll() {
		try {
			return userService.selectAll();
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;

	}

	@GetMapping("/select-one-user/{id}")
	public Optional<User> getOne(@PathVariable int id) {
		try {
			return userService.selectById(id);
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@DeleteMapping("/delete-one-user/{id}")
	public String deleteOne(@PathVariable int id) {
		try {
			userService.deleteOne(id);
			return "User Deleted";
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

}
