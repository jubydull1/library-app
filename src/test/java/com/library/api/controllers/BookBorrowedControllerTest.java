package com.library.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.api.services.BookBorrowedService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookBorrowedController.class)
public class BookBorrowedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookBorrowedService bookBorrowedService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testBorrowBook() throws Exception {
        Long bookId = 1L;
        Long borrowerId = 1L;
        when(bookBorrowedService.borrowBook(bookId, borrowerId)).thenReturn(Optional.of("Book est Book Borrowed by Test Author"));

        mockMvc.perform(post("/api/borrowers/{borrowerId}/books/{bookId}/borrow", borrowerId, bookId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testBorrowBookNotFound() throws Exception {
        Long bookId = 1L;
        Long borrowerId = 1L;

        when(bookBorrowedService.borrowBook(bookId, borrowerId)).thenReturn(Optional.empty());

        mockMvc.perform(post("/api/borrowers/{borrowerId}/books/{bookId}/borrow", borrowerId, bookId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Book not found with id 1"));
    }

    @Test
    public void testReturnBook() throws Exception {
        Long bookId = 1L;
        Long borrowerId = 1L;

        when(bookBorrowedService.returnBook(bookId, borrowerId)).thenReturn(Optional.of("Book est Book Returned by Test Author"));

        mockMvc.perform(post("/api/borrowers/{borrowerId}/books/{bookId}/return", borrowerId, bookId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testReturnBookNotFound() throws Exception {
        Long bookId = 1L;
        Long borrowerId = 1L;

        when(bookBorrowedService.returnBook(bookId, borrowerId)).thenReturn(Optional.of("Book est Book Borrowed by Test Author"));

        mockMvc.perform(post("/api/borrowers/{borrowerId}/books/{bookId}/return", borrowerId, bookId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Book not found with id 1"));
    }
}
