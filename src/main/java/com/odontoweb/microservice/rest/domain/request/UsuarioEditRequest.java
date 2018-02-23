package com.odontoweb.microservice.rest.domain.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioEditRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Boolean admin;
	private String tipoProfissional;
	
	@NotNull(message = "Email é obrigatório")
	@Size(min = 1, max = 100, message = "Tamanho do email deve ser entre 1 e 100")
	private String email;

	@NotNull(message = "Senha é obrigatório")
	private String senha;

	private List<ClinicaRequest> clinicas;

	public UsuarioEditRequest() {
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

	public List<ClinicaRequest> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<ClinicaRequest> clinicas) {
		this.clinicas = clinicas;
	}

	public String getTipoProfissional() {
		return tipoProfissional;
	}

	public void setTipoProfissional(String tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
