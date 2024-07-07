package com.library.api.services.impl;

import com.library.api.entities.BorrowedBook;
import com.library.api.repositories.BookRepository;
import com.library.api.repositories.BorrowerRepository;
import com.library.api.entities.Book;
import com.library.api.entities.Borrower;
import com.library.api.enums.BorrowStatus;
import com.library.api.repositories.BorrowedBookRepository;
import com.library.api.services.BookBorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookBorrowedServiceImpl implements BookBorrowedService {

	@Autowired
	private BorrowerRepository borrowerRepository;
	private BookRepository bookRepository;
	private BorrowedBookRepository borrowedBookRepository;


	public Optional<String> borrowBook(Long bookId, Long borrowerId) {
		Optional<Book> book = bookRepository.findById(bookId);
		Optional<Borrower> borrower = borrowerRepository.findById(borrowerId);

		if (book.isPresent() && borrower.isPresent()) {
			BorrowedBook borrowedBook = BorrowedBook.builder().bookStatus(BorrowStatus.BORROWED.name()).build();
			borrowedBookRepository.save(borrowedBook);
			return Optional.of("Book " + book.get().getTitle() + " Borrowed by " + borrower.get().getName());
		}

		return Optional.empty();
	}

	public Optional<String> returnBook(Long bookId, Long borrowerId) {
		Optional<Book> book = bookRepository.findById(bookId);
		Optional<Borrower> borrower = borrowerRepository.findById(borrowerId);

		Optional<BorrowedBook> borrowedBook = borrowedBookRepository.findByBookIdAndBorrowerId(bookId,borrowerId);
		if (borrowedBook.isPresent()) {
			BorrowedBook borrowedBookDb = borrowedBook.get();
			borrowedBookDb.setBookStatus(BorrowStatus.AVAILABLE.name());
			borrowedBookRepository.save(borrowedBookDb);
			return Optional.of("Book " + book.get().getTitle() + " Returned by " + borrower.get().getName());
        }

		return Optional.empty();
	}
}
