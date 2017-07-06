package com.odontoweb.microservice.rest.domain.response;

import java.io.Serializable;
import java.util.List;

public class UsuarioResponse implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Long telefone;
	private String email;
	private Boolean admin;
	
	private List<RoleResponse> roles;
	private List<ClinicaResponse> clinicas;
	
	public UsuarioResponse() {}

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

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<RoleResponse> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleResponse> roles) {
		this.roles = roles;
	}

	public List<ClinicaResponse> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<ClinicaResponse> clinicas) {
		this.clinicas = clinicas;
	}
	
}