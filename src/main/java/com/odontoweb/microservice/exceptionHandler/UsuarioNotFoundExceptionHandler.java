package com.odontoweb.microservice.exceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.odontoweb.arquitetura.model.ExceptionEntity;
import com.odontoweb.microservice.exception.UsuarioNotFoundException;

@ControllerAdvice
public class UsuarioNotFoundExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UsuarioNotFoundException.class)
	public ResponseEntity<ExceptionEntity> handleUsuarioNotFound(Exception e){
		return new ResponseEntity<ExceptionEntity>(new ExceptionEntity(e.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
}
