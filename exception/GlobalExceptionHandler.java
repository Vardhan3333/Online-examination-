package com.example.Online.Examination.System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<String> exceptionHandler1(Exception1 ex){
		return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.BAD_REQUEST );
	    
	}

}
