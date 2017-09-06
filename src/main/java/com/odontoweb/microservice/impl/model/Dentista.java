package com.odontoweb.microservice.impl.model;

import java.io.Serializable;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.odontoweb.microservice.impl.model.enums.Genero;

@Entity
@Table(name = "TBL_DENTISTA")
public class Dentista implements Serializable {

	private static final long serialVersionUID = 5100117436384354033L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idDentista;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USUARIO", unique = true)
	private Usuario usuario;

	@Column(name = "STR_NOME")
	private String nome;

	@Column(name = "STR_GENERO")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Column(name = "STR_CONSELHO")
	private String conselho;

	@Column(name = "STR_REGISTRO")
	private String registro;

	@Column(name = "STR_CODIGO_BRASILEIRO_OCUPACAO")
	private String codigoBrasileiroOcupacao;

	public Dentista() {
	}

	public Dentista(Long idDentista, String nome, Genero genero, String conselho, String registro,
			String codigoBrasileiroOcupacao, Usuario usuario) {
		this.idDentista = idDentista;
		this.nome = nome;
		this.genero = genero;
		this.conselho = conselho;
		this.registro = registro;
		this.codigoBrasileiroOcupacao = codigoBrasileiroOcupacao;
		this.usuario = usuario;
	}

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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDentista == null) ? 0 : idDentista.hashCode());
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
		Dentista other = (Dentista) obj;
		if (idDentista == null) {
			if (other.idDentista != null)
				return false;
		} else if (!idDentista.equals(other.idDentista))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dentista [id=" + idDentista + ", usuario=" + usuario + ", nome=" + nome + ", genero=" + genero
				+ ", conselho=" + conselho + ", registro=" + registro + ", codigoBrasileiroOcupacao="
				+ codigoBrasileiroOcupacao + "]";
	}

}
