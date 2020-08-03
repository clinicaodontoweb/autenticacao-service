package com.odontoweb.microservice.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.impl.repository.ClinicaRepository;

public class ClinicaService {

	private ClinicaRepository repository;

	@Autowired
	public ClinicaService(ClinicaRepository clinicaRepository) {
		this.repository = clinicaRepository;
	}

	public Clinica getByCnpj(Long cnpj) {
		return repository.findByCnpj(cnpj);
	}

	public List<Clinica> getClinicasByIds(List<Long> ids) {
		return repository.findClinicasByIds(ids);
	}

	public Clinica getById(Long id) {
		return repository.getOne(id);
	}

	public List<Clinica> getClinicas() {
		return repository.findAll();
	}
}
