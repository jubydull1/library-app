package com.library.api.repositories;

import com.library.api.entities.BorrowedBook;
import com.library.api.enums.BorrowStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BorrowedBookRepositoryTest {

    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @Test
    public void testFindBorrowerById() {
        BorrowedBook borrowerBook = BorrowedBook.builder().id(1).bookId(1).borrowerId(1).bookStatus(BorrowStatus.AVAILABLE.name()).build();
        borrowedBookRepository.save(borrowerBook);

        Optional<BorrowedBook> borrowedBook = borrowedBookRepository.findById(borrowerBook.getId());

        assertThat(borrowedBook).isPresent();
        assertThat(borrowedBook.get().getBookStatus()).isEqualTo(BorrowStatus.AVAILABLE.name());
    }
}
