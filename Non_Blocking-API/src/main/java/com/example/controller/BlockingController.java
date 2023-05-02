package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FakeEntity.Student;
import com.example.FakeEntity.User;

import reactor.core.publisher.Flux;

@RestController
public class BlockingController {
	List<Student> li1 = new ArrayList<Student>();

	ArrayList<User> li = new ArrayList<User>();
    
	/*List<User> li = Arrays.asList(
		    new User(1, "Vikas", "Indore", "Engineer"),
		    new User(2, "Sona", "Bhopal", "Engineer"),
		    new User(3, "Nitin", "Dewas", "Tester")
					);*/


@GetMapping("/Blocking")
	public String get()
	{
		return "Hello World";
	}

@GetMapping("/Blocking1")
public List<Student> getList() throws InterruptedException
{
	for(int i=0;i<=20;i++) {
		li1.add(new Student(i,"student",i));
		System.out.println("Student Record"+i);
		Thread.sleep(1000);
	}
	return  li1;
}

}
