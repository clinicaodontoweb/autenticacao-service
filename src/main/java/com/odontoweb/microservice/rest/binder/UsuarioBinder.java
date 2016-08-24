package com.odontoweb.microservice.rest.binder;

import java.util.stream.Collectors;

import com.odontoweb.arquitetura.model.User;
import com.odontoweb.microservice.impl.model.Usuario;

public class UsuarioBinder {

	public User bindUser(Usuario usuario){
		return new User(usuario.getEmail(), 
						usuario.getTenant(), 
						usuario.getRoles()
							.stream()
							.map(role -> role.getRole())
							.collect(Collectors.toList()));
	}
}
