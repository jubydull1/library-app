package com.library.api.services;

import com.library.api.dtos.BookDTO;
import com.library.api.entities.Book;
import com.library.api.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testRegisterBook() {
        Book book = Book.builder().id(1).ISBN("123456789").title("Test Book").author("Test Author").build();
        BookDTO bookDTO = new BookDTO("123456789", "Test Book", "Test Author");
    when(bookRepository.save(any(Book.class))).thenReturn(book);

        BookDTO savedBook = bookService.registerBook(bookDTO);

        assertThat(savedBook).isNotNull();
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testGetAllBooks() {
        bookService.getAllBooks();
        verify(bookRepository, times(1)).findAll();
    }

}
