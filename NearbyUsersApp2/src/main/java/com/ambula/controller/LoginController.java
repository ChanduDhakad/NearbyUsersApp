package com.ambula.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.ambula.exception.LoginException;
import com.ambula.model.*;
import com.ambula.service.LoginService;

@RestController
@RequestMapping("/ambula")
public class LoginController {

	@Autowired
	private LoginService lservices;

	@PostMapping("login/rader")
	public ResponseEntity<CurrentUserSession> readerLoginHandler(@Valid @RequestBody Login login)
			throws LoginException {

		CurrentUserSession usr = lservices.readerLogin(login);

		return new ResponseEntity<CurrentUserSession>(usr, HttpStatus.ACCEPTED);

	}

	@PostMapping("login/admin")
	public ResponseEntity<CurrentUserSession> adminLoginHandler(@Valid @RequestBody Login login) throws LoginException {

		CurrentUserSession cus = lservices.adminlogin(login);

		return new ResponseEntity<CurrentUserSession>(cus, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/Logout")
	public ResponseEntity<String> LogoutHandler(@RequestParam Integer id, @RequestParam String key)
			throws LoginException {

		String message = lservices.Logout(id, key);

		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

}