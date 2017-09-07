package com.odontoweb.microservice.rest.binder;

import java.util.stream.Collectors;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.odontoweb.arquitetura.model.User;
import com.odontoweb.microservice.impl.model.Usuario;
import com.odontoweb.microservice.impl.model.enums.TipoProfissional;
import com.odontoweb.microservice.impl.service.ClinicaService;
import com.odontoweb.microservice.rest.domain.request.UsuarioRequest;
import com.odontoweb.microservice.rest.domain.response.UsuarioResponse;

public class UsuarioBinder {

	private ClinicaService clinicaService;
	private Md5PasswordEncoder encoder;
	
	public UsuarioBinder(ClinicaService clinicaService, Md5PasswordEncoder encoder) {
		this.clinicaService = clinicaService;
		this.encoder = encoder;
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

		return usuarioResponse;
	}

	public Usuario requestToModel(UsuarioRequest usuarioRequest) {
		return new Usuario(usuarioRequest.getId(), usuarioRequest.getEmail(),
				encoder.encodePassword(usuarioRequest.getSenha(), null), usuarioRequest.getAdmin(),
				TipoProfissional.valueOf(usuarioRequest.getTipoProfissional()));
	}
	
	public Usuario requestToModel(UsuarioRequest usuarioRequest, TipoProfissional tipoProfissional) {
		usuarioRequest.setTipoProfissional(tipoProfissional.name());
		Usuario usuario = requestToModel(usuarioRequest);
		usuario.setClinicas(clinicaService.getClinicasByIds(usuarioRequest.getClinicas()));
		return usuario;
	}
}
