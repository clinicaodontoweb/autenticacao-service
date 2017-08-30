package com.odontoweb.microservice.rest.domain.response;

import java.io.Serializable;

public class DentistaResponse implements Serializable {

	private static final long serialVersionUID = -1205176944035282783L;

	private Long idDentista;
	private UsuarioResponse usuarioResponse;
	private String nome;
	private String genero;
	private String conselho;
	private String registro;
	private String codigoBrasileiroOcupacao;

	public DentistaResponse() {
	}

	public DentistaResponse(Long idDentista, UsuarioResponse usuarioResponse, String nome,
			String genero, String conselho, String registro, String codigoBrasileiroOcupacao) {
		this.idDentista = idDentista;
		this.usuarioResponse = usuarioResponse;
		this.nome = nome;

		this.genero = genero;
		this.conselho = conselho;
		this.registro = registro;
		this.codigoBrasileiroOcupacao = codigoBrasileiroOcupacao;
	}

	public Long getIdDentista() {
		return idDentista;
	}

	public void setIdDentista(Long idDentista) {
		this.idDentista = idDentista;
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

	public String getConselho() {
		return conselho;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getCodigoBrasileiroOcupacao() {
		return codigoBrasileiroOcupacao;
	}

	public void setCodigoBrasileiroOcupacao(String codigoBrasileiroOcupacao) {
		this.codigoBrasileiroOcupacao = codigoBrasileiroOcupacao;
	}

}
