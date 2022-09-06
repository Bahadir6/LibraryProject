import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { BookService } from './book.service';
import { Component, OnInit } from '@angular/core';
import { Book } from './book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  public books: Book[] = [];
  public editBook: Book | null =null;
  public deleteBook: Book | null =null;

  constructor(private bookService: BookService) { }

  

  ngOnInit(): void {
    this.getBooks();
  }

  public getBooks(): void {
    this.bookService.getBooks().subscribe(
      (response: Book[]) => {
        this.books=response;
        console.log(this.books);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddBook(addForm: NgForm ): void {
    document.getElementById('add-book-form')!.click();
    this.bookService.addBook(addForm.value).subscribe(
      (response: Book) => {
        console.log(response);
        this.getBooks();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }



  public onOpenModal(book: Book |null ,mode:string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type ='button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    if(mode==='add'){
      button.setAttribute('data-target','#addBookModal');
    }
    if(mode==='edit'){
      
      button.setAttribute('data-target','#updateBookModal');
      
    }
    if(mode==='delete'){
      this.deleteBook=book;
      button.setAttribute('data-target','#deleteBookModal');
    }
    
    container?.appendChild(button);
    button.click();

  }






}
