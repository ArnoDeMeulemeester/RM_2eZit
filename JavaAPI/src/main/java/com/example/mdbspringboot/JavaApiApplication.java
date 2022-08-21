package com.example.mdbspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.mdbspringboot.model.Book;
import com.example.mdbspringboot.repository.bookRepository;

@SpringBootApplication
@EnableMongoRepositories
public class JavaApiApplication implements CommandLineRunner {

	@Autowired
	bookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n----------------SHOW ALL BOOKS---------------------------\n");
        showAllBooks();
	}

	// READ
	// 1. Show all the data
	public void showAllBooks() {
		bookRepository.findAll().forEach(item -> System.out.println(getBookDetails(item)));
	}

	// 2. Get item by name
	public void getBookItemByName(String title) {
		System.out.println("Getting item by name: " + title);
		Book item = bookRepository.findItemByTitle(title);
		System.out.println(getBookDetails(item));
	}

	// 4. Get count of documents in the collection
	public void findCountOfBooks() {
		long count = bookRepository.count();
		System.out.println("Number of documents in the collection: " + count);
	}

	public String getBookDetails(Book item) {

		System.out.println(
				"Book Title: " + item.getTitle() +
						", \nQuantity: " + item.getDescription());

		return "";
	}
}
