package com.odontoweb.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.odontoweb.microservice.impl.repository.RoleRepository;
import com.odontoweb.microservice.impl.repository.UsuarioRepository;
import com.odontoweb.microservice.impl.service.RoleService;
import com.odontoweb.microservice.impl.service.UsuarioService;

@Configuration
public class ServiceConfig {

	@Bean
	public UsuarioService usuarioService(UsuarioRepository repositorio){
		return new UsuarioService(repositorio);
	}
	
	@Bean
	public RoleService roleService(RoleRepository repository){
		return new RoleService(repository);
	}
}
