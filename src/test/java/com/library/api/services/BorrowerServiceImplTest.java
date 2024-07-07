package com.library.api.services;

import com.library.api.dtos.BorrowerDTO;
import com.library.api.entities.Borrower;
import com.library.api.repositories.BorrowerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
public class BorrowerServiceImplTest {

    @Mock
    private BorrowerRepository borrowerRepository;

    @InjectMocks
    private BorrowerService borrowerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterBorrower() {
        Borrower borrower = Borrower.builder().id(1).name("John Doe").email("john.doe@example.com").build();
        BorrowerDTO borrowerDTO = new BorrowerDTO("John Doe", "john@example.com");
        when(borrowerRepository.save(any(Borrower.class))).thenReturn(borrower);

        BorrowerDTO savedBorrower = borrowerService.registerBorrower(borrowerDTO);

        assertThat(savedBorrower).isNotNull();
        verify(borrowerRepository, times(1)).save(borrower);

    }
}
