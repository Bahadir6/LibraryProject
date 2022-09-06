package com.librarymanagement.library.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;

    private String typeofBook;

    private String firstPublicYear;

    private String isbn;

    private boolean available=true;

    private String bookCode;



    public Book() {
    }

    public Book(Long id, String title, String author,
                  String isbn,String typeofBook,String firstPublicYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.typeofBook = typeofBook;
        this.firstPublicYear=firstPublicYear;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public boolean getAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeofBook(){return typeofBook;}
    public void setTypeofBook(String typeofBook){this.typeofBook=typeofBook;}

    public String getFirstPublicYear(){return firstPublicYear;}
    public void setFirstPublicYear(String firstPublicYear){this.firstPublicYear=firstPublicYear;}



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getBookCode() {
        return bookCode;
    }
    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }


    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title  +", author=" + author + ", isbn=" + isbn  + "]";
    }
}
