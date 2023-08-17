package com.ambula.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.ambula.exception.*;
import com.ambula.model.*;
import com.ambula.service.*;

@RestController
@RequestMapping("/ambula")
public class ReaderController {

	@Autowired
	private ReaderService cService;

	@PostMapping("/reader")
	public ResponseEntity<Reader> addReaderHandler(@Valid @RequestBody ReaderDTO readerDTO) throws ReaderException {

		Reader newUser = cService.AddReader(readerDTO);

		return new ResponseEntity<Reader>(newUser, HttpStatus.CREATED);
	}

}
