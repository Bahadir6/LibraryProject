package com.librarymanagement.library.exception.service;


import com.librarymanagement.library.exception.UserNotFoundException;
import com.librarymanagement.library.model.Book;
import com.librarymanagement.library.model.Borrow;
import com.librarymanagement.library.repo.BorrowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class BorrowService {

    private final BorrowRepo borrowRepo;

    @Autowired
    public BorrowService(BorrowRepo borrowRepo) {this.borrowRepo = borrowRepo;}

    public Borrow addBorrow(Borrow borrow){
        borrow.setBorrowCode(UUID.randomUUID().toString());
        LocalDate date = LocalDate.now();
        borrow.setBorrowDate(date);
        borrow.setExpectedReturnDate(date.plusDays(15));

        return borrowRepo.save(borrow);
    }


    public List<Borrow> findAllBorrows(){
        return borrowRepo.findAll();
    }

    public List<Long> findIds(){
        List<Long> ids = borrowRepo.getId();
        return ids;
    }

    public Borrow findBorrowById(Long id){
        return borrowRepo.findBorrowById(id)
                .orElseThrow(() -> new UserNotFoundException("Borrow by id" + id + "was not found"));
    }

    public void deleteBorrow(Long id){

        borrowRepo.deleteBorrowById(id);
    }



}
