package com.example.testspringsecurityrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testspringsecurityrest.entity.User;
import com.example.testspringsecurityrest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User AddUser(User user) {
	 
		return userRepository.save(user);
	}

	@Override
	public List<User> selectAll() {
 
		return  userRepository.findAll();
	}

	@Override
	public Optional<User> selectById(int id) {
 
		return userRepository.findById(id);
	}

	@Override
	public void deleteOne(int id) {
	 
	userRepository.deleteById(id);
	}

}
