package com.example.mdbspringboot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.example.mdbspringboot.model.Book;

@Component
public class customBookRepositoryImpl implements customBookRepository {

  @Autowired
  MongoTemplate mongoTemplate;

  public List<Book> getBooks() {
    Query query = new Query();
    query.addCriteria(Criteria.where("name").regex("c$"));
    List<Book> books = mongoTemplate.find(query, Book.class);
    return books;
  }
  
}
