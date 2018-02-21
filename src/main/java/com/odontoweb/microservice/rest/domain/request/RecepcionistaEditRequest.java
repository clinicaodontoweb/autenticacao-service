package com.odontoweb.microservice.rest.domain.request;

import java.io.Serializable;
import java.util.List;

public class RecepcionistaEditRequest implements Serializable {

	private static final long serialVersionUID = 8545669468435865956L;

	private Long idRecepcionista;
	private UsuarioEditRequest usuarioEditRequest;
	private String nome;
	private String genero;
	private List<DentistaEditRequest> dentistasEditRequest;

	public RecepcionistaEditRequest(Long idRecepcionista, UsuarioEditRequest usuarioResponse, String nome,
			String genero, List<DentistaEditRequest> dentistasEditRequest) {
		this.idRecepcionista = idRecepcionista;
		this.usuarioEditRequest = usuarioResponse;
		this.nome = nome;
		this.genero = genero;
		this.dentistasEditRequest = dentistasEditRequest;
	}

	public RecepcionistaEditRequest() {

	}

	public Long getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(Long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public UsuarioEditRequest getUsuarioEditRequest() {
		return usuarioEditRequest;
	}

	public void setUsuarioEditRequest(UsuarioEditRequest usuarioEditRequest) {
		this.usuarioEditRequest = usuarioEditRequest;
	}

	public List<DentistaEditRequest> getDentistasEditRequest() {
		return dentistasEditRequest;
	}

	public void setDentistasEditRequest(List<DentistaEditRequest> dentistasEditRequest) {
		this.dentistasEditRequest = dentistasEditRequest;
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
}