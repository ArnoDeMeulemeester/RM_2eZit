package com.mongodb.starter.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.starter.models.Book;

@Repository
public interface BookRepository {
  Book save(Book book);

  List<Book> saveAll(List<Book> books);

  List<Book> findAll();

  Book findOne(String id);
}
