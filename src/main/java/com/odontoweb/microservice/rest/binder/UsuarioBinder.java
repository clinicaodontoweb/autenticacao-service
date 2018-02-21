package com.odontoweb.microservice.rest.binder;

import java.util.stream.Collectors;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.odontoweb.arquitetura.model.User;
import com.odontoweb.microservice.impl.model.Usuario;
import com.odontoweb.microservice.impl.model.enums.TipoProfissional;
import com.odontoweb.microservice.impl.service.ClinicaService;
import com.odontoweb.microservice.rest.domain.request.UsuarioEditRequest;
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
		return new User(usuario.getEmail(), usuario.getClinicas().get(0).getCnpj().toString(),
				usuario.getTipoProfissional().toString(), usuario.getAdmin(),
				usuario.getRoles().stream().map(role -> role.getRole()).collect(Collectors.toList()));
	}

	public UsuarioResponse modelToResponse(Usuario usuario) {
		if (usuario == null)
			return null;
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		usuarioResponse.setId(usuario.getId());
		usuarioResponse.setEmail(usuario.getEmail());
		usuarioResponse.setHashKey(usuario.getHashKey());
		usuarioResponse.setAdmin(usuario.getAdmin());
		usuarioResponse.setTipoProfissional(usuario.getTipoProfissional().toString());
		usuarioResponse.setClinicas(new ClinicaBinder().modelToListResponse(usuario.getClinicas()));

		return usuarioResponse;
	}

	private Usuario requestToModel(UsuarioRequest usuarioRequest) {
		return new Usuario(usuarioRequest.getId(), usuarioRequest.getEmail(),
				encoder.encodePassword(usuarioRequest.getSenha(), null),
				encoder.encodePassword(usuarioRequest.getEmail().concat(usuarioRequest.getSenha()), null),
				usuarioRequest.getAdmin(), TipoProfissional.valueOf(usuarioRequest.getTipoProfissional()));
	}
	
	private Usuario requestToModel(UsuarioEditRequest usuarioEditRequest) {
		return new Usuario(usuarioEditRequest.getId(), usuarioEditRequest.getEmail(),
				encoder.encodePassword(usuarioEditRequest.getSenha(), null),
				encoder.encodePassword(usuarioEditRequest.getEmail().concat(usuarioEditRequest.getSenha()), null),
				usuarioEditRequest.getAdmin(), TipoProfissional.valueOf(usuarioEditRequest.getTipoProfissional()));
	}

	public Usuario requestToModel(UsuarioRequest usuarioRequest, TipoProfissional tipoProfissional) {
		usuarioRequest.setTipoProfissional(tipoProfissional.name());
		Usuario usuario = requestToModel(usuarioRequest);
		usuario.setClinicas(clinicaService.getClinicasByIds(usuarioRequest.getClinicas()));
		return usuario;
	}
	
	public Usuario requestToModel(UsuarioEditRequest usuarioEditRequest, TipoProfissional tipoProfissional) {
		usuarioEditRequest.setTipoProfissional(tipoProfissional.name());
		Usuario usuario = requestToModel(usuarioEditRequest);
		usuario.setClinicas(new ClinicaBinder().requestToListModel(usuarioEditRequest.getClinicas()));
		return usuario;
	}
}
