package com.example.Service;

import com.example.Entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

	public Flux<User> getAllUser();
	public Mono<User> Createuser(User user);
	public Mono<Void> deleteUser(long id);
	public Mono<User> getUserById(long id);
}
