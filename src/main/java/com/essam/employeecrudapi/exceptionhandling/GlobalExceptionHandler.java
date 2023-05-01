package com.essam.employeecrudapi.exceptionhandling;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleEntityNotFoundException(EmptyResultDataAccessException exception) {
		EntityErrorResponse responseError = new EntityErrorResponse();
		responseError.setMessage(exception.getMessage());
		responseError.setStatus(HttpStatus.NOT_FOUND.value());
		responseError.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<EntityErrorResponse>(responseError, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleException(Exception exception) {
		EntityErrorResponse responseError = new EntityErrorResponse();
		responseError.setMessage(exception.getMessage());
		responseError.setStatus(HttpStatus.BAD_REQUEST.value());
		responseError.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<EntityErrorResponse>(responseError, HttpStatus.BAD_REQUEST);
		
	}

}
