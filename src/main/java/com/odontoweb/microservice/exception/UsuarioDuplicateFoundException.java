package com.odontoweb.microservice.exception;

public class UsuarioDuplicateFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UsuarioDuplicateFoundException() {
		super("Usuario já existente!");
	}
}
