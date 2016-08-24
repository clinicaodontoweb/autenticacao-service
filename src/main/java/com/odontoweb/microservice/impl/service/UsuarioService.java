package com.odontoweb.microservice.impl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.odontoweb.microservice.exception.UsuarioNotFoundException;
import com.odontoweb.microservice.impl.model.Usuario;
import com.odontoweb.microservice.impl.repository.UsuarioRepository;
import com.odontoweb.microservice.rest.domain.request.UsuarioRequest;

public class UsuarioService {

	private UsuarioRepository repository;
	private Md5PasswordEncoder encoder;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, Md5PasswordEncoder encoder) {
		this.repository = usuarioRepository;
		this.encoder = encoder;
	}
	
	public Usuario login(UsuarioRequest usuario){
		Usuario user = repository.findByEmailAndSenha(usuario.getEmail(), encoder.encodePassword(usuario.getSenha(), null));
		Optional.ofNullable(user).orElseThrow(UsuarioNotFoundException::new);
		
		return user;
	}
	
	public List<Usuario> getUsuarios(){
		return repository.findAll();
	}
	
}

