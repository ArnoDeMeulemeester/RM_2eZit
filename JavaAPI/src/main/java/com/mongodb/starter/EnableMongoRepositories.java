package com.mongodb.starter;

import com.mongodb.starter.repositories.BookRepository;

public @interface EnableMongoRepositories {

  Class<BookRepository> basePackageClasses();

}
