package com.example.testspringsecurityrest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	 	@JsonIgnore
	@ManyToMany(mappedBy = "role")
	private List<User> user = new ArrayList<>();

	 @ManyToMany(cascade = CascadeType.ALL, targetEntity = Authorites.class, fetch = FetchType.EAGER)

	@JoinTable(name = "role_auth", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {

			@JoinColumn(name = "auth_id") })

	private List<Authorites> auth = new ArrayList<>();
	public Role(String name, List<User> user, List<Authorites> auth) {

		this.name = name;
		this.user = user;
		this.auth = auth;
	}
 

	public Role() {}
 


 

	public List<Authorites> getAuth() {
		return auth;
	}


	public void setAuth(List<Authorites> auth) {
		this.auth = auth;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

}
