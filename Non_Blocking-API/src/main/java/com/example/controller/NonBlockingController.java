package com.example.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FakeEntity.Student;
import com.example.FakeEntity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController 
public class NonBlockingController {
	
	
	
	List<Student> li = new ArrayList<Student>();






	@GetMapping(value="/NonBlockingList",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Student> getList() throws InterruptedException
	{
		Flux<Student> li1=Flux.range(1, 20).delayElements(Duration.ofMillis(100))
				.doOnNext(i->System.out.println("Student Record"+i))
				.map(i->new Student(i,"Student",i));
		
		return li1;
	}
	
	@GetMapping(value="/NonBlockingList1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> getNonBlockingList() {
	    return Flux.interval(Duration.ofSeconds(1))
	            .map(sequence -> "Non-blocking message " + sequence);
	}
	
	@GetMapping("/NonBlock")
	public Mono<String> get()
	{
		return Mono.just("Hello World");
	}
}
