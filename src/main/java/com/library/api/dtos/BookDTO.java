package com.library.api.dtos;

import lombok.*;
import com.library.api.entities.Book;

import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

	@NotEmpty
	private String title;

	@NotEmpty
	private String author;

	@NotEmpty
	private String ISBN;

	public static Book toEntity(BookDTO bookDTO) {
		return Book.builder().author(bookDTO.author).ISBN(bookDTO.ISBN).title(bookDTO.title).build();
	}

	public static BookDTO fromEntity(Book book) {
		return BookDTO.builder().author(book.getAuthor()).ISBN(book.getISBN()).title(book.getTitle()).build();
	}
}
