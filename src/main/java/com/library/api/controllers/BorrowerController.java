package com.library.api.controllers;

import com.library.api.dtos.BorrowerDTO;
import io.swagger.v3.oas.annotations.Operation;
import com.library.api.services.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/")
public class BorrowerController {

	@Autowired
	private BorrowerService borrowerService;

	@Operation(description = "Register new borrower")
	@PostMapping("/borrowers")
	public ResponseEntity<BorrowerDTO> registerBorrower(@RequestBody BorrowerDTO borrowerDTO) {
		BorrowerDTO savedBorrower = borrowerService.registerBorrower(borrowerDTO);
		return ResponseEntity.ok(savedBorrower);
	}
}
