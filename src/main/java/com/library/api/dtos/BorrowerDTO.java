package com.library.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import com.library.api.entities.Borrower;


@Data
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerDTO {

	@NotEmpty
	private String name;
	
	@NotEmpty
	@Email
	private String email;

	public static Borrower toEntity(BorrowerDTO dto){
		return Borrower.builder().email(dto.getEmail()).name(dto.getName()).build();
	}
	public static BorrowerDTO fromEntity(Borrower borrower){
		return BorrowerDTO.builder().email(borrower.getEmail()).name(borrower.getName()).build();
	}
}
