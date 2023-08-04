package com.javamicroservices.bookinfoservice.models;

public class Book {

    private String bookId;

    private String name;

    private String author;

    public Book(String bookId, String name, String author) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}


