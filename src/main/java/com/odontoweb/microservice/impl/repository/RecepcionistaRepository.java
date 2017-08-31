package com.odontoweb.microservice.impl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.impl.model.Recepcionista;
import com.odontoweb.microservice.impl.model.Usuario;

public interface RecepcionistaRepository extends JpaRepository<Recepcionista, Long> {
	public Recepcionista findByUsuario(Usuario usuario);

	@Query("SELECT DISTINCT recepcionista FROM Recepcionista recepcionista JOIN recepcionista.usuario.clinicas clinica where clinica = ?1 and recepcionista.usuario.tipoProfissional ='RECEPCIONISTA' ")
	public List<Recepcionista> findAllRecepcionistasByClinica(Clinica clinica);
}
