package com.odontoweb.microservice.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odontoweb.microservice.impl.model.Clinica;

public interface ClinicaRepository extends JpaRepository<Clinica, Long>{

	public Clinica findByCnpj(Long cnpj);
}
