package com.odontoweb.microservice.impl.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.odontoweb.microservice.impl.model.enums.TipoProfissional;

@Entity
@Table(name = "TBL_USUARIO")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "STR_EMAIL", unique = true, updatable = true, insertable = true, nullable = false)
	private String email;

	@Column(name = "STR_SENHA")
	private String senha;

	@Column(name = "BOO_ADMIN")
	private Boolean admin;

	@Enumerated(EnumType.STRING)
	@Column(name = "STR_TIPO_PROFISSIONAL")
	private TipoProfissional tipoProfissional;

	@Column(name = "STR_HASH_KEY")
	private String hashKey;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "TBL_USUARIO_ROLE", joinColumns = {
			@JoinColumn(name = "FK_USUARIO", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "FK_ROLE", referencedColumnName = "ID") })
	private List<Role> roles;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "TBL_USUARIO_CLINICA", joinColumns = {
			@JoinColumn(name = "FK_USUARIO", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "FK_CLINICA", referencedColumnName = "ID") })
	private List<Clinica> clinicas;

	public Usuario() {
	}

	public Usuario(String email, String senha, String hashKey, TipoProfissional tipoProfissional) {
		this.email = email;
		this.senha = senha;
		this.hashKey = hashKey;
		this.admin = Boolean.FALSE;
		this.tipoProfissional = tipoProfissional;
	}

	public Usuario(Long id, String email, String senha, String hashKey, Boolean admin,
			TipoProfissional tipoProfissional) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.hashKey = hashKey;
		this.admin = admin;
		this.tipoProfissional = tipoProfissional;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	public TipoProfissional getTipoProfissional() {
		return tipoProfissional;
	}

	public void setTipoProfissional(TipoProfissional tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", admin=" + admin + ", roles=" + roles + "]";
	}
}
