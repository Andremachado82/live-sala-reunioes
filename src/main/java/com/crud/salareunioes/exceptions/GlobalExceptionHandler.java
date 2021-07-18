package com.crud.salareunioes.exceptions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	Timestamp stamp = new Timestamp(System.currentTimeMillis());
	String dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(stamp);
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
		
		
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND.value(), e.getMessage(), dateFormat);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception e, WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), dateFormat);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
	}
}
