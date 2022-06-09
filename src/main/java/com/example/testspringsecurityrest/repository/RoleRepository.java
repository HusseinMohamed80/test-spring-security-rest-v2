package com.example.testspringsecurityrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testspringsecurityrest.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
