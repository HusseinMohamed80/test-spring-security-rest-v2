package com.example.testspringsecurityrest.services;

import java.util.List;
import java.util.Optional;

import com.example.testspringsecurityrest.entity.Role;

public interface RoleService {

	public Role AddRole(Role role);
	public List<Role> selectAll();
	public Optional<Role> selectById(int id);
	public void deleteOne(int id);
	
}
