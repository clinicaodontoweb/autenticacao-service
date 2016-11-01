package com.odontoweb.microservice.rest.binder;

import java.util.stream.Collectors;

import com.odontoweb.arquitetura.model.User;
import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.impl.model.Usuario;
import com.odontoweb.microservice.rest.domain.response.UsuarioResponse;

public class UsuarioBinder {
	
	private ClinicaBinder clinicaBinder;
	private RoleBinder roleBinder;
	
	public UsuarioBinder(ClinicaBinder clinicaBinder, RoleBinder roleBinder) {
		this.clinicaBinder = clinicaBinder;
		this.roleBinder = roleBinder;
	}

	public User bindUser(Usuario usuario){
		return new User(usuario.getEmail(), 
						usuario.getClinicas().get(0).getCnpj().toString(),
						usuario.getRoles()
							.stream()
							.map(role -> role.getRole())
							.collect(Collectors.toList()));
	}
	
	public User bindUser(Usuario usuario, Clinica clinica){
		return new User(usuario.getEmail(), 
						clinica.getCnpj().toString(),
						usuario.getRoles()
							.stream()
							.map(role -> role.getRole())
							.collect(Collectors.toList()));
	}
	
	public User bindUser(Usuario usuario, String tenant){
		return new User(usuario.getEmail(), 
						tenant,
						usuario.getRoles()
							.stream()
							.map(role -> role.getRole())
							.collect(Collectors.toList()));
	}
	
	public UsuarioResponse bindToResponse(Usuario usuario){
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		
		usuarioResponse.setId(usuario.getId());
		usuarioResponse.setNome(usuario.getNome());
		usuarioResponse.setTelefone(usuario.getTelefone());
		usuarioResponse.setEmail(usuario.getEmail());
		usuarioResponse.setAdmin(usuario.getAdmin());
		usuarioResponse.setClinicas(clinicaBinder.bindToResponse(usuario.getClinicas()));
		usuarioResponse.setRoles(roleBinder.bindToResponse(usuario.getRoles()));
		
		return usuarioResponse;
	}
}
