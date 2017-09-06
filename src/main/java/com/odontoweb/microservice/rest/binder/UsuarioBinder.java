package com.odontoweb.microservice.rest.binder;

import java.util.stream.Collectors;

import com.odontoweb.arquitetura.model.User;
import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.impl.model.Usuario;
import com.odontoweb.microservice.impl.model.enums.TipoProfissional;
import com.odontoweb.microservice.rest.domain.request.UsuarioRequest;
import com.odontoweb.microservice.rest.domain.response.UsuarioResponse;

public class UsuarioBinder {

	public UsuarioBinder() {
	}

	public User bindUser(Usuario usuario) {
		return new User(usuario.getEmail(),
				usuario.getClinicas().get(0).getCnpj().toString(),
				usuario.getTipoProfissional().toString(),
				usuario.getAdmin(),
				usuario.getRoles().stream().map(role -> role.getRole()).collect(Collectors.toList()));
	}

	public UsuarioResponse modelToResponse(Usuario usuario) {
		if(usuario == null ) return null;
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		usuarioResponse.setId(usuario.getId());
		usuarioResponse.setEmail(usuario.getEmail());
		usuarioResponse.setAdmin(usuario.getAdmin());
		
		usuarioResponse.setClinicas(new ClinicaBinder().bindToResponse(usuario.getClinicas()));
//		usuarioResponse.setRoles(new RoleBinder().bindToResponse(usuario.getRoles()));

		return usuarioResponse;
	}

	public Usuario requestToModel(UsuarioRequest usuarioRequest) {
		return new Usuario(usuarioRequest.getId(), usuarioRequest.getEmail(),
				usuarioRequest.getSenha(), usuarioRequest.getAdmin(),
				TipoProfissional.valueOf(usuarioRequest.getTipoProfissional()));
	}
	
	public Usuario requestToModel(UsuarioRequest usuarioRequest, TipoProfissional tipoProfissional) {
		usuarioRequest.setTipoProfissional(tipoProfissional.name());
		Usuario usuario = requestToModel(usuarioRequest);
		return usuario;
	}
}
