package com.example.testspringsecurityrest.services;

import java.util.List;
import java.util.Optional;

import com.example.testspringsecurityrest.entity.User;

public interface UserService {
public User AddUser(User user);
public List<User> selectAll();
public Optional<User> selectById(int id);
public void deleteOne(int id);

}
