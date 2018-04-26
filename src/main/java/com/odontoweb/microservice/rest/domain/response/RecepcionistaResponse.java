package com.odontoweb.microservice.rest.domain.response;

import java.io.Serializable;
import java.util.List;

public class RecepcionistaResponse implements Serializable {

	private static final long serialVersionUID = 8545669468435865956L;

	private Long idRecepcionista;
	private UsuarioResponse usuario;
	private String nome;
	private String genero;
	private List<DentistaResponse> dentistas;

	public RecepcionistaResponse(Long idRecepcionista, UsuarioResponse usuario, String nome, String genero,
			List<DentistaResponse> dentistas) {
		this.idRecepcionista = idRecepcionista;
		this.usuario = usuario;
		this.nome = nome;
		this.genero = genero;
		this.dentistas = dentistas;
	}

	public RecepcionistaResponse() {

	}

	public Long getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(Long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public UsuarioResponse getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioResponse usuario) {
		this.usuario = usuario;
	}

	public List<DentistaResponse> getDentistas() {
		return dentistas;
	}

	public void setDentistas(List<DentistaResponse> dentistas) {
		this.dentistas = dentistas;
	}

}