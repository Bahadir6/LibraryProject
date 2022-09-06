package com.librarymanagement.library.repo;

import com.librarymanagement.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface BookRepo extends JpaRepository<Book,Long> {
    Optional<Book> findBookById(Long id);

    void deleteBookById(Long id);

    Optional<Book> findBookByAvailable(boolean available);
}
