package com.renaspring.springdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BookIDGenerator"
    )
    @SequenceGenerator(
            name = "BookIDGenerator",
            allocationSize = 1
    )
    private Integer id;
    private String title;
    private String author;
    private BookStatus status;
//    private Integer rating;
//    private Date dateFinished;
//    private Date dateStarted;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Book(Integer id, String title, String author, BookStatus status) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
//        this.dateStarted = dateStarted;
//        this.dateFinished = dateFinished;
//        this.rating = rating;
    }

    public Book() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", author='" + author + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    //this is a test!!
}

