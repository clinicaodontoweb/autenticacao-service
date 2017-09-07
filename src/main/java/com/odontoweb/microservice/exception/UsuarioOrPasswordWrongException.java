package com.odontoweb.microservice.exception;

public class UsuarioOrPasswordWrongException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UsuarioOrPasswordWrongException() {
		super("Usuario ou Senha nao conferem.");
	}
}
