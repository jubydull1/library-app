package com.library.api.repositories;

import com.library.api.entities.Borrower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
public class BorrowerRepositoryTest {

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Test
    public void testSaveBorrower() {
        Borrower borrower = Borrower.builder().id(1).name("John Doe").email("john.doe@example.com").build();
        Borrower savedBorrower = borrowerRepository.save(borrower);

        assertThat(savedBorrower).isNotNull();
        assertThat(savedBorrower.getId()).isNotNull();
        assertThat(savedBorrower.getName()).isEqualTo("John Doe");
        assertThat(savedBorrower.getEmail()).isEqualTo("john.doe@example.com");
    }

    @Test
    public void testFindBorrowerById() {
        Borrower borrower = Borrower.builder().id(1).name("John Doe").email("john.doe@example.com").build();
        borrowerRepository.save(borrower);

        Optional<Borrower> foundBorrower = borrowerRepository.findById(borrower.getId());

        assertThat(foundBorrower).isPresent();
        assertThat(foundBorrower.get().getName()).isEqualTo("Jane Doe");
        assertThat(foundBorrower.get().getEmail()).isEqualTo("jane.doe@example.com");
    }
}
