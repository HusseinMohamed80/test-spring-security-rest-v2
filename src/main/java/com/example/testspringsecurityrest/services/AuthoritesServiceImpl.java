package com.example.testspringsecurityrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testspringsecurityrest.entity.Authorites;
import com.example.testspringsecurityrest.repository.AuthoritesRepository;
@Service
public class AuthoritesServiceImpl implements AuthoritesService {

	@Autowired
	private AuthoritesRepository authoritesRepository;

	@Override
	public Authorites AddAuthorites(Authorites auth) {

		return authoritesRepository.save(auth);
	}

	@Override
	public List<Authorites> selectAll() {

		return authoritesRepository.findAll();
	}

	@Override
	public Optional<Authorites> selectById(int id) {

		return authoritesRepository.findById(id);
	}

	@Override
	public void deleteOne(int id) {

		authoritesRepository.deleteById(id);
	}

}
