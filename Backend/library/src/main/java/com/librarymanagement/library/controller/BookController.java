package com.librarymanagement.library.controller;


import com.librarymanagement.library.model.Book;
import com.librarymanagement.library.exception.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

   @GetMapping("/all")
   public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books =bookService.findAllBooks();
        return new ResponseEntity<>(books,HttpStatus.OK);
   }

    @GetMapping("/find/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id ){
        Book book =bookService.findBookById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updateBook = bookService.updateBook(book);
        return new ResponseEntity<>(updateBook,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Long id ){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
