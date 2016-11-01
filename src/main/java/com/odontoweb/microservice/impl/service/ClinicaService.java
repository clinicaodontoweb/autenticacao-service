package com.odontoweb.microservice.impl.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.impl.repository.ClinicaRepository;

public class ClinicaService {

	private ClinicaRepository repository;
	
	@Autowired
	public ClinicaService(ClinicaRepository clinicaRepository) {
		this.repository = clinicaRepository;
	}
	
	public Clinica getByCnpj(Long cnpj){
		return repository.findByCnpj(cnpj);
	}
	
	public Clinica getById(Long id){
		return repository.findOne(id);
	}
}
