package com.example.testspringsecurityrest.services;

import java.util.List;
import java.util.Optional;

import com.example.testspringsecurityrest.entity.Authorites;

public interface AuthoritesService {

	public Authorites AddAuthorites(Authorites auth);

	public List<Authorites> selectAll();

	public Optional<Authorites> selectById(int id);

	public void deleteOne(int id);

}
