package com.library.api.repositories;

import com.library.api.entities.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long>{

    Optional<BorrowedBook> findByBookIdAndBorrowerId(long bookId, long borrowerId);
}
