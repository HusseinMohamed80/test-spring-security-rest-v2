package com.example.testspringsecurityrest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.testspringsecurityrest.entity.User;
import com.example.testspringsecurityrest.repository.UserRepository;

 
@Service
public class UserPricipleDetailsServices implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user=userRepository.findByUserName(username);
		 UserPrinciple userPriciple = new  UserPrinciple(user);
		 
		return userPriciple;
	}

}
