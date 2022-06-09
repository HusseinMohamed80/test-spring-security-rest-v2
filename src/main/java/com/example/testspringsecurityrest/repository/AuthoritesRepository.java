package com.example.testspringsecurityrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testspringsecurityrest.entity.Authorites;

@Repository
public interface AuthoritesRepository extends JpaRepository<Authorites, Integer> {

}
