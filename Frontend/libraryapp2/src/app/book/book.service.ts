import { Book } from './book';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';

@Injectable({providedIn:'root'})
export class BookService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.apiServerUrl}/book/all`);
  }

  public addBook(book:Book): Observable<Book> {
    return this.http.post<Book>(`${this.apiServerUrl}/book/add`,book);
  }

  public updateBook(book:Book): Observable<Book> {
    return this.http.put<Book>(`${this.apiServerUrl}/book/update`,book);
  }

  public deleteBook(id:number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/book/delete/${id}`);
  }

}