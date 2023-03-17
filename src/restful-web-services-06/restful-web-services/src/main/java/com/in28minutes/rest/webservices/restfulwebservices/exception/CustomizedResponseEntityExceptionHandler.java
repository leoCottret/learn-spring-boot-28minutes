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
	
	
	public ResponseEntity<ErrorDetails> getGenericResponseEntity(Exception ex, WebRequest request, HttpStatus httpStatusCode) {
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false)),  
				httpStatusCode
			);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		return getGenericResponseEntity(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
	}
 
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		return getGenericResponseEntity(ex, request, HttpStatus.NOT_FOUND);
	}
	
}
