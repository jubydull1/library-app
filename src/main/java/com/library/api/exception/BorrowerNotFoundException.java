package com.library.api.exception;

public class BorrowerNotFoundException extends ResourceNotFoundException {
    public BorrowerNotFoundException(Long id) {
        super("Borrower not found with id " + id);
    }
}
