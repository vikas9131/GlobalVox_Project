package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Book;
import com.example.repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/books")
public class HomeController {

    @Autowired BookRepository bookRepository;

    @GetMapping("/get")
    public Flux<Book> getHome() {

        return bookRepository.findAll();

    }

    @PostMapping("/save")
    public Mono<Book> postBook(@RequestBody Book book) {

        return bookRepository.save(book);
    }

    @PutMapping("/update")
    public Mono<Book> updateBook(@RequestBody Book book) {

        return bookRepository.save(book);

    }

    @DeleteMapping("/delete")
    public boolean deleteBook(@RequestBody Book book) {

        try {
            bookRepository.deleteById(book.getId()).block(); // Note this!
            return true;

        } catch (Exception e) {

            return false;
        }
    }
}