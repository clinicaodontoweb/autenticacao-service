package com.odontoweb.microservice.rest.domain.request;

import java.io.Serializable;

public class ClinicaRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Long cnpj;
	private Boolean ativo;

	public ClinicaRequest() {
	}

	public ClinicaRequest(Long id, String nome, Long cnpj) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
