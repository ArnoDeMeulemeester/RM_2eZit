package com.mongodb.starter.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.starter.models.Book;

@Service
public class MongoDBBookRepository implements BookRepository {

  private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                          .readPreference(ReadPreference.primary())
                                                                          .readConcern(ReadConcern.MAJORITY)
                                                                          .writeConcern(WriteConcern.MAJORITY)
                                                                          .build();
    private final MongoClient client;
    private MongoCollection<Book> bookCollection;

    public MongoDBBookRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        bookCollection = client.getDatabase("RM2EZIT").getCollection("books", Book.class);
    }

  @Override
  public Book save(Book book) {
    book.setId(new ObjectId());
    bookCollection.insertOne(book);
    return book;
  }

  @Override
  public List<Book> saveAll(List<Book> books) {
    try (ClientSession clientSession = client.startSession()) {
      return clientSession.withTransaction(() -> {
        books.forEach(b -> b.setId(new ObjectId()));
        bookCollection.insertMany(clientSession, books);
        return books;
      }, txnOptions);
    }
  }

  @Override
  public List<Book> findAll() {
    return bookCollection.find().into(new ArrayList<>());
  }

  @Override
  public Book findOne(String id) {
    // TODO Auto-generated method stub
    return null;
  }  
}
