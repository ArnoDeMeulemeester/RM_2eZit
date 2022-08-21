package com.mongodb.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.starter.repositories.BookRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = BookRepository.class)
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
