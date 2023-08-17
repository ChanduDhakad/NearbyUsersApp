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
	public ResponseEntity<Reader> addUserHandler(@Valid @RequestBody ReaderDTO readerDTO) throws ReaderException {

		Reader newUser = cService.AddReader(readerDTO);

		return new ResponseEntity<Reader>(newUser, HttpStatus.CREATED);
	}
	
	/*

	@PutMapping("/UpdateUser")
	public ResponseEntity<Reader> updateUserHandler(@RequestParam String key, @RequestBody Reader User)
			throws UserException, LoginException {

		Reader updatedUser = cService.updateUser(key, User);

		return new ResponseEntity<Reader>(updatedUser, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUserHandler(Integer UserId, String key) throws UserException, LoginException {

		String message = cService.deleteUser(UserId, key);

		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}
	
	*/

}
