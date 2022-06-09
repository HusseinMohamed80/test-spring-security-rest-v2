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
import com.example.testspringsecurityrest.entity.Role;
import com.example.testspringsecurityrest.services.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping("/add-role")
	public Role Add(@RequestBody Role role) {
		try {
			role.setId(0);

			return roleService.AddRole(role);
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@PutMapping("/update-role")
	public Role update(@RequestBody Role role) {
		try {
			return roleService.AddRole(role);
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@GetMapping("/select-all-role")
	public List<Role> getAll() {
		try {
			return roleService.selectAll();
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@GetMapping("/select-one-role/{id}")
	public Optional<Role> getOne(@PathVariable int id) {
		try {
			return roleService.selectById(id);
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

	@DeleteMapping("/delete-one-role/{id}")
	public String deleteOne(@PathVariable int id) {
		try {
			roleService.deleteOne(id);
			return "Role Deleted";
		} catch (Exception Ex) {

			System.out.println("Error");

		}
		return null;
	}

}
