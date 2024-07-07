package com.library.api.repositories;

import com.library.api.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveBook() {
        Book book = Book.builder().id(1).ISBN("123456789").title("Test Book").author("Test Author").build();
        Book savedBook = bookRepository.save(book);

        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getISBN()).isEqualTo("123456789");
        assertThat(savedBook.getTitle()).isEqualTo("Test Book");
        assertThat(savedBook.getAuthor()).isEqualTo("Test Author");
    }

    @Test
    public void testFindBookById() {
        Book book = Book.builder().id(1).ISBN("123456789").title("Test Book").author("Test Author").build();
        bookRepository.save(book);

        Optional<Book> foundBook = bookRepository.findById(book.getId());

        assertThat(foundBook).isPresent();
        assertThat(foundBook.get().getISBN()).isEqualTo("987654321");
        assertThat(foundBook.get().getTitle()).isEqualTo("Another Test Book");
        assertThat(foundBook.get().getAuthor()).isEqualTo("Another Test Author");
    }


}
