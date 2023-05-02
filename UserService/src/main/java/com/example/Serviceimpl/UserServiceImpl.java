package com.example.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Service.UserService;
import com.example.entity.User;
import com.example.repository.UserRepository;

public class UserServiceImpl  implements UserService {

	@Autowired
	UserRepository userepository;
	
	@Override
	public User CreateUser(User user) {
			userepository.save(user);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		
		return userepository.findAll();
	}

	@Override
	public User updateUser(Long Id,User user) {
		
		//Long Id=user.getUserId();
		List<User> li=userepository.findAll();
		
		return null;
	}

	@Override
	public User deleteUser(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
