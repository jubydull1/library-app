package com.library.api.controllers;

import com.library.api.exception.BookNotFoundException;
import com.library.api.services.BookBorrowedService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/borrow-book")
public class BookBorrowedController {


    @Autowired
    private BookBorrowedService bookBorrowedService;

    @Operation(description = "Borrow book by User")
    @GetMapping("/{borrowerId}/books/{bookId}/borrow")
    public ResponseEntity<String> borrowBook(@PathVariable Long borrowerId, @PathVariable Long bookId) {
        Optional<String> statusOps = bookBorrowedService.borrowBook(bookId, borrowerId);
        return statusOps.map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }

    @Operation(description = "Return book by User")
    @GetMapping("/{borrowerId}/books/{bookId}/return")
    public ResponseEntity<String> returnBook(@PathVariable Long borrowerId, @PathVariable Long bookId) {
        Optional<String> statusOps = bookBorrowedService.returnBook(bookId, borrowerId);
        return statusOps.map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }
}
