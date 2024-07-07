package com.library.api.services;

import com.library.api.dtos.BookDTO;

import java.util.List;

public interface BookService {

	public BookDTO registerBook(BookDTO bookDTO) ;

	public List<BookDTO> getAllBooks() ;
}
