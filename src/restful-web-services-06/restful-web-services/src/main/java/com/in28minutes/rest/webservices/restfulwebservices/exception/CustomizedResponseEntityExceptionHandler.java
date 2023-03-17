package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	public ResponseEntity<ErrorDetails> getGenericResponseEntity(String message, WebRequest request, HttpStatus httpStatusCode) {
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDate.now(), message, request.getDescription(false)),  
				httpStatusCode
			);
	}
 
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		return getGenericResponseEntity(ex.getMessage(), request, HttpStatus.NOT_FOUND);
	}
	
}
