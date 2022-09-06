package com.librarymanagement.library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class Borrow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long member_id;

    private Long book_i;

    private String member_name;

    private String book_name;

    private LocalDate  borrowDate;
    private LocalDate  expectedReturnDate;

    private String borrowCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public Long getBook_i() {
        return book_i;
    }

    public void setBook_i(Long book_i) {
        this.book_i = book_i;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public LocalDate  getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate  getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate  expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    @Override
    public String toString() {
        return "Borrow [id=" + id + ", member_id=" + member_id + ", book_i=" + book_i + ", member_name="
                + member_name + ", book_name=" + book_name + ", borrowDate=" + borrowDate + ", expectedReturnDate="
                + expectedReturnDate + ", borrowCode=" + borrowCode + "]";
    }






}
