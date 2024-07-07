package com.library.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.api.dtos.BookDTO;
import com.library.api.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testRegisterBook() throws Exception {
        BookDTO book = new BookDTO("123456789", "Test Book", "Test Author");
        when(bookService.registerBook(any(BookDTO.class))).thenReturn(book);

        mockMvc.perform(post("/api/v1/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isbn").value("123456789"))
                .andExpect(jsonPath("$.title").value("Test Book"))
                .andExpect(jsonPath("$.author").value("Test Author"));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        BookDTO book1 = new BookDTO("123456789", "Test Book 1", "Test Author 1");
        BookDTO book2 = new BookDTO("987654321", "Test Book 2", "Test Author 2");
        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        mockMvc.perform(get("/api/v1/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].isbn").value("123456789"))
                .andExpect(jsonPath("$[0].title").value("Test Book 1"))
                .andExpect(jsonPath("$[0].author").value("Test Author 1"))
                .andExpect(jsonPath("$[1].isbn").value("987654321"))
                .andExpect(jsonPath("$[1].title").value("Test Book 2"))
                .andExpect(jsonPath("$[1].author").value("Test Author 2"));
    }


}
