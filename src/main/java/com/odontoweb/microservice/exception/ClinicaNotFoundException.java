package com.odontoweb.microservice.exception;

public class ClinicaNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ClinicaNotFoundException() {
		super("Nenhum clínica encontrada");
	}
}
