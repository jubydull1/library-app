package com.library.api.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Data
@ToString
@Entity
@Table(name = "Borrowed_Book")
public class BorrowedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private long bookId;
    @Column(nullable = false)
    private long borrowerId;
    @Column(nullable = false)
    private String bookStatus;
}
