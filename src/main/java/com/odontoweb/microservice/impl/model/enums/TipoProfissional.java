package com.odontoweb.microservice.impl.model.enums;

public enum TipoProfissional {
	DENTISTA("Dentista"), RECEPCIONISTA("Recepcionista");

	private String tipoProfissional;

	private TipoProfissional(String tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}

	@Override
	public String toString() {
		return tipoProfissional;
	}
}
