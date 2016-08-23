package com.odontoweb.microservice.impl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.odontoweb.arquitetura.model.User;
import com.odontoweb.microservice.exception.UsuarioNotFoundException;
import com.odontoweb.microservice.impl.model.Usuario;
import com.odontoweb.microservice.impl.repository.UsuarioRepository;
import com.odontoweb.microservice.rest.domain.request.UsuarioRequest;

public class UsuarioService {

	private UsuarioRepository repository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.repository = usuarioRepository;
	}
	
	public Usuario login(UsuarioRequest usuario){
		Usuario user = repository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		Optional.ofNullable(user).orElseThrow(UsuarioNotFoundException::new);
		
		return user;
	}
	
	public List<Usuario> getUsuarios(){
		return repository.findAll();
	}
	
	public User UsuarioToUserToken(Usuario usuario){
		return new User(usuario.getEmail(), usuario.getTenant(), usuario.getRoles().stream().map(role -> role.getRole()).collect(Collectors.toList()));
	}
}

