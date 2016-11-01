package com.odontoweb.microservice.exceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.odontoweb.arquitetura.model.ExceptionEntity;
import com.odontoweb.microservice.exception.ClinicaNotFoundException;

@ControllerAdvice
public class ClinicaNotFoundExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ClinicaNotFoundException.class)
	public ResponseEntity<ExceptionEntity> handleClinicaNotFound(Exception e){
		return new ResponseEntity<ExceptionEntity>(new ExceptionEntity(e.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
