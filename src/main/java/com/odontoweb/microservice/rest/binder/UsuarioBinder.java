package com.odontoweb.microservice.rest.binder;

import java.util.stream.Collectors;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.odontoweb.arquitetura.model.User;
import com.odontoweb.microservice.exception.UsuarioNotFoundException;
import com.odontoweb.microservice.impl.model.Usuario;
import com.odontoweb.microservice.impl.model.enums.TipoProfissional;
import com.odontoweb.microservice.impl.service.UsuarioService;
import com.odontoweb.microservice.rest.domain.request.UsuarioRequest;
import com.odontoweb.microservice.rest.domain.response.UsuarioResponse;

public class UsuarioBinder {

	private Md5PasswordEncoder encoder;
	private UsuarioService usuarioService;

	public UsuarioBinder(Md5PasswordEncoder encoder, UsuarioService usuarioService) {
		this.encoder = encoder;
		this.usuarioService = usuarioService;
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

	private Usuario requestToModel(UsuarioRequest usuarioRequest, String senha, String hashKey) {
		return new Usuario(usuarioRequest.getId(), usuarioRequest.getEmail(), senha, hashKey, usuarioRequest.getAdmin(),
				TipoProfissional.valueOf(usuarioRequest.getTipoProfissional().toUpperCase()));
	}

	public Usuario requestNovoToModel(UsuarioRequest usuarioRequest, TipoProfissional tipoProfissional) {
		usuarioRequest.setTipoProfissional(tipoProfissional.name());
		Usuario usuario = requestToModel(usuarioRequest);
		usuario.setClinicas(new ClinicaBinder().requestToListModel(usuarioRequest.getClinicas()));
		return usuario;
	}

	public Usuario requestEditarToModel(UsuarioRequest usuarioRequest) {
		Usuario usuarioSaved = usuarioService.getByEmail(usuarioRequest.getEmail());
		if (usuarioSaved != null) {
			Usuario usuario = requestToModel(usuarioRequest, usuarioSaved.getSenha(), usuarioSaved.getHashKey());
			usuario.setClinicas(new ClinicaBinder().requestToListModel(usuarioRequest.getClinicas()));
			return usuario;
		} else {
			throw new UsuarioNotFoundException();
		}
	}
}
