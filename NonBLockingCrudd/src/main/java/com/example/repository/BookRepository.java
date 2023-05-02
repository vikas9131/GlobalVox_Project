package com.example.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.Entity.Book;

public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
}
