package com.odontoweb.microservice.rest.domain.response;

import java.io.Serializable;

public class DentistaResponse implements Serializable {

	private static final long serialVersionUID = -1205176944035282783L;

	private Long idDentista;
	private UsuarioResponse usuario;
	private String nome;
	private String genero;
	private String registro;
	private Boolean ativo;

	public DentistaResponse() {
	}

	public DentistaResponse(Long idDentista, UsuarioResponse usuario, String nome, String genero, String registro,
			Boolean ativo) {
		this.idDentista = idDentista;
		this.usuario = usuario;
		this.nome = nome;
		this.ativo = ativo;
		this.genero = genero;
		this.registro = registro;
	}

	public Long getIdDentista() {
		return idDentista;
	}

	public void setIdDentista(Long idDentista) {
		this.idDentista = idDentista;
	}

	public UsuarioResponse getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioResponse usuario) {
		this.usuario = usuario;
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
