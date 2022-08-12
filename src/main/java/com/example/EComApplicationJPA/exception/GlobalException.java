package com.example.EComApplicationJPA.exception;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException
{
	// it handle the custume exception
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<?> handleResourseNotFoundException(ResourseNotFoundException exception,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(0),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	
	// it handle global exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(ResourseNotFoundException exception,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(0),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}