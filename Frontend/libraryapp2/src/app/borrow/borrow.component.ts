import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { BorrowService } from './borrow.service';
import { Component, OnInit } from '@angular/core';
import { Borrow } from './borrow';

@Component({
  selector: 'app-borrow',
  templateUrl: './borrow.component.html',
  styleUrls: ['./borrow.component.css']
})
export class BorrowComponent implements OnInit {


  public borrows: Borrow[] = [];

  constructor(private borrowService:BorrowService) { }

  ngOnInit(): void {
    this.getBorrows();
  }

  public getBorrows(): void {
    this.borrowService.getBorrows().subscribe(
      (response: Borrow[]) => {
        this.borrows=response;
        console.log(this.borrows);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddBorrow(addForm: NgForm ): void {
    document.getElementById('add-borrow-form')!.click();
    this.borrowService.addBorrow(addForm.value).subscribe(
      (response: Borrow) => {
        console.log(response);
        this.getBorrows();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

 
  public onOpenModal(borrow: Borrow | null,mode:string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type ='button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    if(mode==='add'){
      button.setAttribute('data-target','#addBorrowModal');
    }
    if(mode==='edit'){
      button.setAttribute('data-target','#updateBorrowModal');
    }
    if(mode==='delete'){
      button.setAttribute('data-target','#deleteBorrowModal');
    }
    container?.appendChild(button);
    button.click();

  }


}