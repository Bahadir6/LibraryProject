package com.librarymanagement.library.controller;


import com.librarymanagement.library.model.Borrow;


import com.librarymanagement.library.exception.service.BookService;
import com.librarymanagement.library.exception.service.BorrowService;
import com.librarymanagement.library.exception.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {



    private  BookService bookService;

    private MemberService memberService;


    private  BorrowService borrowService;

    public BorrowController(BookService bookService, MemberService memberService, BorrowService borrowService) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.borrowService = borrowService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Borrow>> getAllBorrows(){
        List<Borrow> borrows = borrowService.findAllBorrows();

        return new ResponseEntity<>(borrows, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Borrow>  addBorrow(@RequestBody Borrow borrow){

        List<Long> ids = borrowService.findIds();
        for(Long i:ids){
            if(LocalDate.now().isAfter(borrowService.findBorrowById(i).getExpectedReturnDate()) )
            {
                memberService.findMemberById(i).setActivity(false);
            }
        }

        if((bookService.findBookById(borrow.getBook_i()).getAvailable())==true &&
                (memberService.findMemberById(borrow.getMember_id()).getActivity()==true)
        )
        {
            bookService.findBookById(borrow.getBook_i()).setAvailable(false);
            borrow.setBook_name(bookService.findBookById((borrow.getBook_i())).getTitle());
            borrow.setMember_name(memberService.findMemberById(borrow.getMember_id()).getName());
            Borrow newBorrow = borrowService.addBorrow(borrow);
            return new ResponseEntity<>(newBorrow, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Borrow> deleteBorrow(@PathVariable("id") Long id ){
        /*
        bookService.findBookById(borrowService.findBorrowById(id).getBook_i()).setAvailable(true);
        if(memberService.findMemberById(borrowService.findBorrowById(id).getMember_id()).getActivity()==false){
            memberService.deleteMember(borrowService.findBorrowById(id).getMember_id());
        }

         */


        borrowService.deleteBorrow(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
