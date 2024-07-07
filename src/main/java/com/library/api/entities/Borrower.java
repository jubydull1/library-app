package com.library.api.entities;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "Borrower")
public class Borrower {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Name" , nullable = false)
	private String name;

	@Column(name = "Email",unique = true, nullable = false)
	private String email;
}
