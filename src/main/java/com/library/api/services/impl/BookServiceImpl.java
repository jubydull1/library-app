package com.library.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.library.api.dtos.BookDTO;
import com.library.api.repositories.BookRepository;
import com.library.api.entities.Book;
import com.library.api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;


	public BookDTO registerBook(BookDTO bookDTO) {
		Book book = BookDTO.toEntity(bookDTO);
		Book save = bookRepository.save(book);
		return BookDTO.fromEntity(save);
	}

	public List<BookDTO> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map(BookDTO::fromEntity).collect(Collectors.toList());
	}

}
