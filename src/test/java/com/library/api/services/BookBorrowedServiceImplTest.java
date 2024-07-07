package com.library.api.services;

import com.library.api.entities.Book;
import com.library.api.entities.Borrower;
import com.library.api.repositories.BookRepository;
import com.library.api.repositories.BorrowerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.library.api.repositories.BorrowedBookRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BookBorrowedServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BorrowerRepository borrowerRepository;

    @Mock
    private BorrowedBookRepository borrowedBookRepository;
    @InjectMocks
    private BookBorrowedService bookBorrowedService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void testBorrowBook() {
        Book book = Book.builder().id(1).ISBN("123456789").title("Test Book").author("Test Author").build();
        Borrower borrower = Borrower.builder().id(1).name("John Doe").email("john.doe@example.com").build();

        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(book));
        when(borrowerRepository.findById(anyLong())).thenReturn(Optional.of(borrower));

        Optional<String> borrowedBook = bookBorrowedService.borrowBook(1L, 1L);

        assertThat(borrowedBook).isPresent();
        verify(bookRepository, times(1)).findById(1L);
        verify(borrowerRepository, times(1)).findById(1L);
    }

    @Test
    public void testReturnBook() {
        Book book = Book.builder().id(1).ISBN("123456789").title("Test Book").author("Test Author").build();
        Borrower borrower = Borrower.builder().id(1).name("John Doe").email("john.doe@example.com").build();

        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(book));
        when(borrowerRepository.findById(anyLong())).thenReturn(Optional.of(borrower));

        Optional<String> returnedBook = bookBorrowedService.returnBook(1L, 1L);

        assertThat(returnedBook).isPresent();
        verify(bookRepository, times(1)).findById(1L);
        verify(borrowerRepository, times(1)).findById(1L);
    }
}
