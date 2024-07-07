package com.library.api.controllers;

import com.library.api.dtos.BookDTO;
import com.library.api.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class BookController {
	@Autowired
	private BookService bookService;

	@Operation(description = "Register new book")
	@PostMapping("/books")
	public ResponseEntity<BookDTO> registerBook(@RequestBody BookDTO bookDTO) {
		BookDTO savedBook = bookService.registerBook(bookDTO);
		return ResponseEntity.ok(savedBook);
	}
	@Operation(description = "Get All Books from Library")
	@GetMapping("/books")
	public ResponseEntity<List<BookDTO>> getAllBooks() {
		List<BookDTO> books = bookService.getAllBooks();
		return ResponseEntity.ok(books);
	}

}
