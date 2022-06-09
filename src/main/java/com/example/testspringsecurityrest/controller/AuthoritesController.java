package com.example.testspringsecurityrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.testspringsecurityrest.entity.Authorites;
import com.example.testspringsecurityrest.services.AuthoritesService;

@RestController
@RequestMapping("/api")
public class AuthoritesController {

	@Autowired
	private AuthoritesService authoritesService;

	@PostMapping("/add-auth")
	public Authorites Add(@RequestBody Authorites auth) {
		try {
			auth.setId(0);

			return authoritesService.AddAuthorites(auth);
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@PutMapping("/update-auth")
	public Authorites update(@RequestBody Authorites auth) {
		try {
			return authoritesService.AddAuthorites(auth);
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@GetMapping("/select-all-auth")
	public List<Authorites> getAll() {
		try {
			return authoritesService.selectAll();
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@GetMapping("/select-one-auth/{id}")
	public Optional<Authorites> getOne(@PathVariable int id) {
		try {
			return authoritesService.selectById(id);
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@DeleteMapping("/delete-one-auth/{id}")
	public String deleteOne(@PathVariable int id) {
		try {
			authoritesService.deleteOne(id);
			return "Auth Deleted";
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

}
