package com.xoriant.settlement.expection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandeler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CurrencyDetailsNotFoundException.class)
	public ResponseEntity<String> currencyDetailsNotFoundException(
			CurrencyDetailsNotFoundException currencyDetailsNotFoundException) {
		return new ResponseEntity<String>("Currency Details Not Present in Database", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserInputException.class)
	public ResponseEntity<String> userInputExceptionHandeler(UserInputException exception) {
		return new ResponseEntity<String>("Please check Input Fileds !", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ElementNotFoundException.class)
	public ResponseEntity<String> elementNotFoundException(ElementNotFoundException elementNotFoundException) {
		return new ResponseEntity<String>("Element Not Found Exception", HttpStatus.BAD_REQUEST);
	}
}