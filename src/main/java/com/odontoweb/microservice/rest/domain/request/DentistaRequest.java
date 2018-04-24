package com.odontoweb.microservice.rest.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class DentistaRequest implements Serializable {

	private static final long serialVersionUID = -5217785988080284220L;

	private Long idDentista;

	@NotNull(message = "Nome é obrigatório!")
	private String nome;

	@NotNull(message = "Gênero é obrigatório!")
	private String genero;

	@NotNull(message = "Registro é obrigatório!")
	private String registro;

	private UsuarioRequest usuario;

	private Boolean ativo;

	public Long getIdDentista() {
		return idDentista;
	}

	public void setIdDentista(Long idDentista) {
		this.idDentista = idDentista;
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

	public UsuarioRequest getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioRequest usuario) {
		this.usuario = usuario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
