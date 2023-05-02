package com.example.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.User;
import com.example.Service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CrudController {

     
	@Autowired
	UserService userservice;
	
	
	@GetMapping("/getallusers")
	public Flux<User> getallusers()
	{
		return userservice.getAllUser();
	}


	 
	   @GetMapping("/{id}")
	    public Mono<User> getUserById(@PathVariable long id) {
	        return userservice.getUserById(id);
	    }
	   
	   @DeleteMapping("delele/{id}")
	   public Mono<Void> delteById(@PathVariable long id)
	   {
		return userservice.deleteUser(id);
		   
	   }
	   
	   @PostMapping("/create")
	   public Mono<User> createUser(@RequestBody User user){
		   return  userservice.Createuser(user);
	   }
	
}
