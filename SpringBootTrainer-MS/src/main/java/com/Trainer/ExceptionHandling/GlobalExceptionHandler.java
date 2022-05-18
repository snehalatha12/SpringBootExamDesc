package com.Trainer.ExceptionHandling;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Exception> resourceNotFoundException(ResourceNotFoundException ex){
		Exception res = new Exception();
		res.setErrorCode("NOT_FOUND");
		res.setErrorMessage(ex.getMessage());
		res.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<Exception>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(KeyViolationException.class)
	public ResponseEntity<Exception> KeyViolationException(KeyViolationException ex){
		Exception res = new Exception();
		res.setErrorCode("BAD_REQUEST");
		res.setErrorMessage(ex.getMessage());
		res.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<Exception>(res, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		Map <String,String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach( error -> {
			errors.put(((FieldError)error).getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}
