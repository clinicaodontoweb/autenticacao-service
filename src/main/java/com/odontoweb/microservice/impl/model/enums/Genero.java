package com.odontoweb.microservice.impl.model.enums;

public enum Genero {
	MASCULINO("Masculino"), FEMININO("Feminino");

	private String genero;

	private Genero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return genero;
	}
}
