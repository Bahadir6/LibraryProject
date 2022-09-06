package com.librarymanagement.library.repo;

import com.librarymanagement.library.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface BorrowRepo extends JpaRepository<Borrow,Long> {

    void deleteBorrowById(Long id);

    @Query("select b.id from Borrow b")
    List<Long> getId();

    Optional<Borrow> findBorrowById(Long id);
}
