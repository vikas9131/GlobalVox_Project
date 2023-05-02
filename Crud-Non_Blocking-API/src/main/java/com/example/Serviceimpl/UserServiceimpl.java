package com.example.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.User;
import com.example.Repository.UserRepository;
import com.example.Service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceimpl implements UserService
{
	@Autowired
	UserRepository userrepository;

	@Override
	public Flux<User> getAllUser() {
		return userrepository.findAll();
		
	}

	@Override
	public Mono<User> Createuser(User user) {
	
		return userrepository.save(user);
	}

	@Override
	public Mono<Void> deleteUser(long id) {
		
	return userrepository.deleteById(id);
	
	}

	@Override
	public Mono<User> getUserById(long id) {
		
		return userrepository.findById(id);
	}

	
	
}
