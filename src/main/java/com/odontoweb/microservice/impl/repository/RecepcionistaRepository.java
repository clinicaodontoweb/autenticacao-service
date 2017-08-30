package com.odontoweb.microservice.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odontoweb.microservice.impl.model.Recepcionista;
import com.odontoweb.microservice.impl.model.Usuario;

public interface RecepcionistaRepository extends JpaRepository<Recepcionista, Long> {
	public Recepcionista findByUsuario(Usuario usuario);
}
