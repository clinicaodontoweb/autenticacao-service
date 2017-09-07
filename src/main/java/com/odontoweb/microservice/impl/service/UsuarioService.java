package com.odontoweb.microservice.impl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.odontoweb.microservice.exception.ClinicaNotFoundException;
import com.odontoweb.microservice.exception.UsuarioOrPasswordWrongException;
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

	public Usuario login(UsuarioRequest usuario) {
		Usuario user = repository.findByEmailAndSenha(usuario.getEmail(),
				encoder.encodePassword(usuario.getSenha(), null));
		Optional.ofNullable(user).orElseThrow(UsuarioOrPasswordWrongException::new);
		Optional.ofNullable(user.getClinicas()).orElseThrow(ClinicaNotFoundException::new);
		if (user.getClinicas().isEmpty())
			throw new ClinicaNotFoundException();

		return user;
	}

	public List<Usuario> getUsuarios() {
		return repository.findAll();
	}

	public Usuario getByEmail(String email) {
		return repository.findByEmail(email);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public boolean save(Usuario usuario) {
		return repository.save(usuario) != null;
	}
	
	public boolean usuarioExist(String email){
		if(getByEmail(email) != null) return true;
		return false;
	}
}
