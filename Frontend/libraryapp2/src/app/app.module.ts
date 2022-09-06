
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';import { FormsModule } from '@angular/forms';
import { BookComponent } from './book/book.component';
import { Routes,RouterModule } from '@angular/router';
import { MemberComponent } from './member/member.component';
import { BorrowComponent } from './borrow/borrow.component';


const routes: Routes = [
  {path:"member", component:MemberComponent, pathMatch:"full"},
  {path:"book", component:BookComponent },
  {path:"borrow", component:BorrowComponent }
 
];

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    MemberComponent,
    BorrowComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule, FormsModule,RouterModule,
    RouterModule.forRoot(routes)
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
