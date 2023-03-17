package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	// default exception handler
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		return getGenericResponseEntity(ex.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR);
	}
 
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		return getGenericResponseEntity(ex.getMessage(), request, HttpStatus.NOT_FOUND);
	}
	
	// handle not valid fields (not respecting constraints of @Size, @Past etc.)
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// ex.getFieldError().getDefaultMessage() returns the first error message, which is here the first violated property constraint
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
