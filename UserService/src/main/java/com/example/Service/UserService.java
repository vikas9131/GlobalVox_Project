package com.example.Service;

import java.util.List;

import com.example.entity.User;

public interface UserService {

	public User CreateUser(User user);
	public List<User> getAllUser();
	public User updateUser(Long Id,User user);
	public User deleteUser(Long Id);
	
}
