package com.masai.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.masai.exception.DriverException;
import com.masai.exception.UserException;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(DriverException.class)
	public ResponseEntity<MyErrorDetails> DriverExecptionHanddler(DriverException e){
		
		return new ResponseEntity<MyErrorDetails>(new MyErrorDetails(e.getMessage(),LocalDateTime.now()), HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> UserExecptionhandller(UserException e){
		
		return new ResponseEntity<MyErrorDetails>(new MyErrorDetails(e.getMessage(),LocalDateTime.now()), HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> globalExecption(Exception e){
		
		return new ResponseEntity<MyErrorDetails>(new MyErrorDetails(e.getMessage(),LocalDateTime.now()), HttpStatus.BAD_REQUEST);
		
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> validationExceptionHandler(MethodArgumentNotValidException e){
		
	
		return new ResponseEntity<MyErrorDetails>(new MyErrorDetails(e.getBindingResult().getFieldError().getDefaultMessage(),LocalDateTime.now()), HttpStatus.BAD_REQUEST);
		
	}

}
