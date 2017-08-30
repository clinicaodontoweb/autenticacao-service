package com.odontoweb.microservice.rest.domain.response;

import java.io.Serializable;
import java.util.List;

public class RecepcionistaResponse implements Serializable {

	private static final long serialVersionUID = 8545669468435865956L;

	private Long idRecepcionista;
	private UsuarioResponse usuarioResponse;
	private String nome;
	private String genero;
	private List<DentistaResponse> dentistasResponse;

	public RecepcionistaResponse(Long idRecepcionista, UsuarioResponse usuarioResponse, String nome, String genero,
			List<DentistaResponse> dentistasResponse) {
		this.idRecepcionista = idRecepcionista;
		this.usuarioResponse = usuarioResponse;
		this.nome = nome;
		this.genero = genero;
		this.dentistasResponse = dentistasResponse;
	}

	public RecepcionistaResponse() {

	}

	public Long getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(Long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public UsuarioResponse getUsuarioResponse() {
		return usuarioResponse;
	}

	public void setUsuarioResponse(UsuarioResponse usuarioResponse) {
		this.usuarioResponse = usuarioResponse;
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

	public List<DentistaResponse> getDentistasResponse() {
		return dentistasResponse;
	}

	public void setDentistasResponse(List<DentistaResponse> dentistasResponse) {
		this.dentistasResponse = dentistasResponse;
	}

}