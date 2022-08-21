package com.mongodb.starter.models;

import org.bson.types.ObjectId;

public class Book {
  private ObjectId id;
  private String title;
  private String description;

  public Book() {

  }

  public String getTitle() {
    return this.title;
  }

  public String getDescription() {
    return this.description;
  }

  public ObjectId getId() {
    return this.id;
  }

  public void setTitle(String t) {
    this.title = t;
  }

  public void setDescription(String d) {
    this.description = d;
  }

  public Book setId(ObjectId id) {
    this.id = id;
    return this;
  }

  @Override
    public String toString() {
      return String.format("title: %s, description: %s", getTitle(), getDescription());
    }
}
