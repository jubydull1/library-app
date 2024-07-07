package com.library.api.services;

import java.util.Optional;

public interface BookBorrowedService {
    Optional<String> borrowBook(Long bookId, Long borrowerId);
    Optional<String> returnBook(Long bookId, Long borrowerId);
}
