import { Observable } from 'rxjs';
import { Borrow } from './borrow';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({providedIn:'root'})
export class BorrowService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getBorrows(): Observable<Borrow[]> {
    return this.http.get<Borrow[]>(`${this.apiServerUrl}/borrow/all`);
  }

  public addBorrow(borrow:Borrow): Observable<Borrow> {
    return this.http.post<Borrow>(`${this.apiServerUrl}/borrow/add`,borrow);
  }

  public updateBorrow(borrow:Borrow): Observable<Borrow> {
    return this.http.put<Borrow>(`${this.apiServerUrl}/borrow/update`,borrow);
  }

  public deleteBorrow(borrowId:number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/borrow/delete/${borrowId}`);
  }

}