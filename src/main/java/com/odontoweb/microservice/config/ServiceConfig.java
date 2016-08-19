package com.odontoweb.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.odontoweb.microservice.impl.repository.TesteRepository;
import com.odontoweb.microservice.impl.repository.UsuarioRepository;
import com.odontoweb.microservice.impl.service.TesteService;
import com.odontoweb.microservice.impl.service.UsuarioService;

@Configuration
public class ServiceConfig {

	@Bean
	public UsuarioService usuarioService(UsuarioRepository repositorio){
		return new UsuarioService(repositorio);
	}
	
	@Bean
	public TesteService testeService(TesteRepository repository){
		return new TesteService(repository);
	}
}
