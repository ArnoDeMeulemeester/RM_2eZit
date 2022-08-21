package com.example.mdbspringboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mdbspringboot.model.Book;

public interface bookRepository extends MongoRepository<Book, String> {
  
  @Query("{title:'?0'}")
	Book findItemByTitle(String name);
	
	@Query(value="{title:'?0'}", fields="{'title' : 1, 'description' : 1}")
	List<Book> findAll(String title);
	
	public long count();

}
