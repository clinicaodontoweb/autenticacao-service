package com.odontoweb.microservice.impl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.odontoweb.microservice.impl.model.Clinica;

public interface ClinicaRepository extends JpaRepository<Clinica, Long>{

	public Clinica findByCnpj(Long cnpj);
	
	@Query("SELECT clinica FROM Clinica clinica where clinica.id in ?1")
	public List<Clinica> findClinicasByIds(List<Long> ids);
}
