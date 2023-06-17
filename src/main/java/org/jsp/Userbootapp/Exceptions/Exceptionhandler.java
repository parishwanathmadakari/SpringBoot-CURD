package org.jsp.Userbootapp.Exceptions;

import org.jsp.Userbootapp.DTO.Responsestructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class Exceptionhandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Idnotfoundexception.class)
	public ResponseEntity<Responsestructure<String>> Idnotfoundexception(Idnotfoundexception e) {

		Responsestructure<String> s = new Responsestructure<>();

		s.setBody("User not found");
		s.setMessage(e.getMessage());
		s.setCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<Responsestructure<String>>(s, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InvalidCredinctionals.class)
	public ResponseEntity<Responsestructure<String>> invalidcredientials(InvalidCredinctionals e) {

		Responsestructure<String> s = new Responsestructure<>();
		s.setBody("Invalid User name and email");
		s.setMessage(e.getMessage());
		s.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Responsestructure<String>>(s, HttpStatus.NOT_FOUND);
	}

}
