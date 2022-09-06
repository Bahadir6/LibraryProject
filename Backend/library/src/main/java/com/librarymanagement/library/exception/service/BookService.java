package com.librarymanagement.library.exception.service;


import com.librarymanagement.library.exception.UserNotFoundException;
import com.librarymanagement.library.model.Book;
import com.librarymanagement.library.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book addBook(Book book){
        book.setBookCode(UUID.randomUUID().toString());
        return bookRepo.save(book);

    }

    public List<Book> findAllBooks(){
        return bookRepo.findAll();
    }

    public Book updateBook(Book book){
        return bookRepo.save(book);
    }

    public Book findBookById(Long id){
        return bookRepo.findBookById(id)
                .orElseThrow(() -> new UserNotFoundException("Book by id" + id + "was not found"));
    }


    public void deleteBook(Long id){
        bookRepo.deleteBookById(id);
    }


}
