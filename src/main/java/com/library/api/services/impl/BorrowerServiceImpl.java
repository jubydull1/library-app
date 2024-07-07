package com.library.api.services.impl;

import com.library.api.dtos.BorrowerDTO;
import com.library.api.entities.Borrower;
import com.library.api.repositories.BorrowerRepository;
import com.library.api.services.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl implements BorrowerService {

	@Autowired
	private BorrowerRepository borrowerRepository;

	public BorrowerDTO registerBorrower(BorrowerDTO borrowerDTO) {
		Borrower borrower = BorrowerDTO.toEntity(borrowerDTO);
		Borrower saved = borrowerRepository.save(borrower);
		return BorrowerDTO.fromEntity(saved);
	}

}
