package com.example.mdbspringboot.repository;

import java.util.List;

import com.example.mdbspringboot.model.Book;

public interface customBookRepository {
  List<Book> getBooks();
}
