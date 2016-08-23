package com.odontoweb.microservice.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.odontoweb.microservice.impl.model.Role;
import com.odontoweb.microservice.impl.repository.RoleRepository;

public class RoleService {

	private RoleRepository repository;
	
	@Autowired
	public RoleService(RoleRepository repository) {
		this.repository = repository;
	}
	
	public List<Role> findAll(){
		return repository.findAll();
	}
}
