package com.ambula.exception;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> LoginExceptionHandler(LoginException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> AdminExceptionHandler(AdminException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err,  HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ReaderException.class)
	public ResponseEntity<MyErrorDetails> readerExceptionHandler(ReaderException re, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(re.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserLocationException.class)
	public ResponseEntity<MyErrorDetails> userLocationExceptionHandler(UserLocationException ule, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ule.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err,  HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> NoHandlerFoundException(NoHandlerFoundException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));
		System.out.println("nhe");
		return new ResponseEntity<MyErrorDetails>(err,  HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> AllException(Exception ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MyErrorDetails> myAdminExceptionHandler(ConstraintViolationException le, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(le.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), "Validation Error",
				me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

}