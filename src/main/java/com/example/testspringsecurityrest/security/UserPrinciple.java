package com.example.testspringsecurityrest.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.testspringsecurityrest.entity.Role;
import com.example.testspringsecurityrest.entity.User;

 

public class UserPrinciple implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private User user;
	
 

	public UserPrinciple(User user  ) {
		this.user = user;
	}
 

	public UserPrinciple() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		this.user.getRole().forEach(p -> {
 
			GrantedAuthority au = new SimpleGrantedAuthority(p.getName());
		 

		
			roles.add(au);

		});
		  
		 /* List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		  
		  this.role.getAuth().forEach(p -> {
		 GrantedAuthority ro = new SimpleGrantedAuthority(p.getName());
		 auth.add(ro);
		 });
		  roles.add((GrantedAuthority) auth);*/
 		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
	/*	try {

			return user.getActive() == 1;
		} catch (Exception e) {
			return false;

		}*/
		return true;
	}

	/*public String getAddress() {
		// TODO Auto-generated method stub
		return user.getAddress();
	}

	public String getAge() {
		// TODO Auto-generated method stub
		return user.getAge();
	}*/
	public List<Role> getRole() {
		
		return user.getRole();
		
	}
}
