package com.odontoweb.microservice.rest.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String tenant;
	private Boolean admin;
	private String tipoProfissional;

	@NotNull(message = "Email é obrigatório")
	@Size(min = 1, max = 100, message = "Tamanho do email deve ser entre 1 e 100")
	private String email;

	@NotNull(message = "Senha é obrigatório")
	private String senha;

	public UsuarioRequest() {
	}

	public UsuarioRequest(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getTipoProfissional() {
		return tipoProfissional;
	}

	public void setTipoProfissional(String tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}

}