package com.odontoweb.microservice.rest.domain.request;

import java.io.Serializable;

public class DentistaEditRequest implements Serializable {

	private static final long serialVersionUID = -1205176944035282783L;

	private Long idDentista;
	private UsuarioEditRequest usuarioEditRequest;
	private String nome;
	private String genero;
	private String registro;
	private Boolean ativo;

	public DentistaEditRequest() {
	}

	public DentistaEditRequest(Long idDentista, UsuarioEditRequest usuarioEditRequest, String nome, String genero,
			String registro, Boolean ativo) {
		this.idDentista = idDentista;
		this.usuarioEditRequest = usuarioEditRequest;
		this.nome = nome;
		this.genero = genero;
		this.registro = registro;
	}

	public Long getIdDentista() {
		return idDentista;
	}

	public void setIdDentista(Long idDentista) {
		this.idDentista = idDentista;
	}

	public UsuarioEditRequest getUsuarioEditRequest() {
		return usuarioEditRequest;
	}

	public void setUsuarioEditRequest(UsuarioEditRequest usuarioEditRequest) {
		this.usuarioEditRequest = usuarioEditRequest;
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

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
