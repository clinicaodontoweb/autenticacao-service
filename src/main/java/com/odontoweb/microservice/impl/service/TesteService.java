package com.odontoweb.microservice.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.odontoweb.microservice.impl.model.Teste;
import com.odontoweb.microservice.impl.repository.TesteRepository;

public class TesteService {

	private TesteRepository repository;
	
	@Autowired
	public TesteService(TesteRepository repository) {
		this.repository = repository;
	}
	
	public List<Teste> findAll(){
		return repository.findAll();
	}
}
