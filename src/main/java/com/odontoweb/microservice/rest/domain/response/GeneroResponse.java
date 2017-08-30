package com.odontoweb.microservice.rest.domain.response;

import java.io.Serializable;

public class GeneroResponse implements Serializable {

	private static final long serialVersionUID = -3562159033517559499L;

	private String genero;

	public GeneroResponse(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
