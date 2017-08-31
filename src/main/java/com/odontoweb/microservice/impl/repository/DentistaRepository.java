package com.odontoweb.microservice.impl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.impl.model.Dentista;
import com.odontoweb.microservice.impl.model.Usuario;

public interface DentistaRepository extends JpaRepository<Dentista, Long> {
	public Dentista findByUsuario(Usuario usuario);
	
	@Query("SELECT DISTINCT dentista FROM Dentista dentista JOIN dentista.usuario.clinicas clinica where clinica = ?1 and dentista.usuario.tipoProfissional ='DENTISTA' ")
	public List<Dentista> findAllDentistasByClinica(Clinica clinica);
}
