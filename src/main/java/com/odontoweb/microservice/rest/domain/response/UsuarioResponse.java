package com.odontoweb.microservice.rest.domain.response;

import java.io.Serializable;
import java.util.List;

public class UsuarioResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private String hashKey;
	private Boolean admin;
	private String tipoProfissional;
	private List<RoleResponse> roles;
	private List<ClinicaResponse> clinicas;

	public UsuarioResponse() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTipoProfissional() {
		return tipoProfissional;
	}

	public void setTipoProfissional(String tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

}
