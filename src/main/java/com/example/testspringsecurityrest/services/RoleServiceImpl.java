package com.example.testspringsecurityrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testspringsecurityrest.entity.Role;
import com.example.testspringsecurityrest.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role AddRole(Role role) {

		return roleRepository.save(role);
	}

	@Override
	public List<Role> selectAll() {

		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> selectById(int id) {

		return roleRepository.findById(id);
	}

	@Override
	public void deleteOne(int id) {
		roleRepository.deleteById(id);
	}

}
