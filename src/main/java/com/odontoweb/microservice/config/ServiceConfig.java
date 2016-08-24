package com.odontoweb.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.odontoweb.microservice.impl.repository.RoleRepository;
import com.odontoweb.microservice.impl.repository.UsuarioRepository;
import com.odontoweb.microservice.impl.service.RoleService;
import com.odontoweb.microservice.impl.service.UsuarioService;
import com.odontoweb.microservice.rest.binder.UsuarioBinder;

@Configuration
public class ServiceConfig {

	@Bean
	public UsuarioService usuarioService(UsuarioRepository repositorio, Md5PasswordEncoder encoder){
		return new UsuarioService(repositorio, encoder);
	}
	
	@Bean
	public RoleService roleService(RoleRepository repository){
		return new RoleService(repository);
	}
	
	@Bean
	public UsuarioBinder usuarioBinder(){
		return new UsuarioBinder();
	}
}
