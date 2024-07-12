package com.renaspring.springdemo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_sequence"
    )
    private Integer id;
    private String title;
    private String author;
    private BookStatus status;
    private Integer rating;
    private Date dateFinished;
    private Date dateStarted;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Book(Integer id, String title, String author, BookStatus status, Date dateStarted, Date dateFinished, Integer rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
        this.dateStarted = dateStarted;
        this.dateFinished = dateFinished;
        this.rating = rating;
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
                ", rating=" + rating +
                ", dateFinished=" + dateFinished +
                ", dateStarted=" + dateStarted +
                '}';
    }
}

