package com.odontoweb.microservice.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.odontoweb.arquitetura.exception.response.ExceptionResponse;
import com.odontoweb.arquitetura.model.User;
import com.odontoweb.arquitetura.security.JWTAuthorizationUtil;
import com.odontoweb.microservice.exception.UsuarioDuplicateFoundException;
import com.odontoweb.microservice.exception.UsuarioNotFoundException;
import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.impl.model.Usuario;
import com.odontoweb.microservice.impl.service.ClinicaService;
import com.odontoweb.microservice.impl.service.DentistaService;
import com.odontoweb.microservice.impl.service.RecepcionistaService;
import com.odontoweb.microservice.impl.service.RoleService;
import com.odontoweb.microservice.impl.service.UsuarioService;
import com.odontoweb.microservice.rest.binder.DentistaBinder;
import com.odontoweb.microservice.rest.binder.RecepcionistaBinder;
import com.odontoweb.microservice.rest.binder.UsuarioBinder;
import com.odontoweb.microservice.rest.domain.request.DentistaRequest;
import com.odontoweb.microservice.rest.domain.request.RecepcionistaRequest;
import com.odontoweb.microservice.rest.domain.request.UsuarioRequest;
import com.odontoweb.microservice.rest.domain.response.ClinicasDentistasResponse;
import com.odontoweb.microservice.rest.domain.response.DentistaResponse;
import com.odontoweb.microservice.rest.domain.response.RecepcionistaResponse;
import com.odontoweb.microservice.rest.domain.response.TokenResponse;
import com.odontoweb.microservice.rest.domain.response.UsuarioResponse;

@RestController
public class Endpoint {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RoleService roleService;

	@Autowired
	ClinicaService clinicaService;

	@Autowired
	UsuarioBinder usuarioBinder;

	@Autowired
	JWTAuthorizationUtil jwtUtil;

	@Autowired
	DentistaService dentistaService;

	@Autowired
	RecepcionistaService recepcionistaService;

	@Autowired
	DentistaBinder dentistaBinder;

	@Autowired
	RecepcionistaBinder recepcionistaBinder;

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<TokenResponse> authenticate(@RequestBody @Valid UsuarioRequest usuarioRequest) {
		Usuario usuario = usuarioService.login(usuarioRequest);
		User user = usuarioBinder.bindUser(usuario);

		return new ResponseEntity<TokenResponse>(new TokenResponse(jwtUtil.build(user)), HttpStatus.OK);
	}

	@RequestMapping(value = "/auth/{id}", method = RequestMethod.GET)
	public ResponseEntity<TokenResponse> updateToken(@PathVariable("id") Long idClinica,
			Authentication authentication) {
		Clinica clinica = clinicaService.getById(idClinica);
		User user = (User) authentication.getPrincipal();
		user.setTenant(clinica.getCnpj().toString());

		return new ResponseEntity<TokenResponse>(new TokenResponse(jwtUtil.build(user)), HttpStatus.OK);
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public ResponseEntity<UsuarioResponse> me(Authentication authentication) {
		User user = (User) authentication.getPrincipal();

		return new ResponseEntity<UsuarioResponse>(
				usuarioBinder.modelToResponse(usuarioService.getByEmail(user.getUsername())), HttpStatus.OK);
	}

	@RequestMapping(value = "/dentista", method = RequestMethod.POST)
	public ResponseEntity<?> saveDentista(@RequestBody @Valid DentistaRequest dentistaRequest) {
		try {
			if (usuarioService.usuarioExist(dentistaRequest.getUsuarioRequest().getEmail())) {
				throw new UsuarioDuplicateFoundException();
			}
			dentistaService.save(dentistaBinder.requestToModel(dentistaRequest));
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<ExceptionResponse>(
					new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/dentista", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDentista(@RequestBody @Valid DentistaRequest dentistaRequest,
			Authentication authentication) {
		try {
			if (!usuarioService.usuarioExist(dentistaRequest.getUsuarioRequest().getEmail())) {
				throw new UsuarioNotFoundException();
			}
			dentistaService.save(dentistaBinder.requestToModel(dentistaRequest));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ExceptionResponse>(
					new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/dentista/{id}", method = RequestMethod.GET)
	public ResponseEntity<DentistaResponse> findDentistaById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(dentistaBinder.modelToResponse(dentistaService.findById(id)), HttpStatus.OK);
	}

	@RequestMapping(value = "/dentista/clinica/{cnpj}", method = RequestMethod.GET)
	public ResponseEntity<List<DentistaResponse>> findAllDentistasByClinica(@PathVariable("cnpj") Long cnpj) {
		return new ResponseEntity<List<DentistaResponse>>(
				dentistaBinder.modelToListResponse(dentistaService.findAllDentistasByClinica(cnpj)), HttpStatus.OK);
	}

	@RequestMapping(value = "/dentista/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDentista(@PathVariable("id") Long id) {
		dentistaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/recepcionista", method = RequestMethod.POST)
	public ResponseEntity<?> saveRecepcionista(@RequestBody @Valid RecepcionistaRequest recepcionistaRequest,
			Authentication authentication) {
		try {
			if (usuarioService.usuarioExist(recepcionistaRequest.getUsuarioRequest().getEmail())) {
				throw new UsuarioDuplicateFoundException();
			}
			recepcionistaService.save(recepcionistaBinder.requestToModel(recepcionistaRequest));
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<ExceptionResponse>(
					new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/recepcionista", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRecepcionista(@RequestBody @Valid RecepcionistaRequest recepcionistaRequest,
			Authentication authentication) {
		try {
			if (!usuarioService.usuarioExist(recepcionistaRequest.getUsuarioRequest().getEmail())) {
				throw new UsuarioNotFoundException();
			}
			recepcionistaService.save(recepcionistaBinder.requestToModel(recepcionistaRequest));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ExceptionResponse>(
					new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/recepcionista/clinica/{cnpj}", method = RequestMethod.GET)
	public ResponseEntity<List<RecepcionistaResponse>> findAllRecepcionistasByClinica(@PathVariable("cnpj") Long cnpj) {
		return new ResponseEntity<List<RecepcionistaResponse>>(
				recepcionistaBinder.modelToListResponse(recepcionistaService.findAllRecepcionistasByClinica(cnpj)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/recepcionista/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRecepcionista(@PathVariable("id") Long id) {
		recepcionistaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario/clinica/dentista", method = RequestMethod.GET)
	public ResponseEntity<?> findAllClinicasDentistasByUsuario(Authentication authentication) {
		try {
			User user = (User) authentication.getPrincipal();
			if (!usuarioService.usuarioExist(user.getUsername()))
				throw new UsuarioNotFoundException();
			Usuario usuario = usuarioService.getByEmail(user.getUsername());
			return new ResponseEntity<ClinicasDentistasResponse>(dentistaBinder.modelToResponse(usuario.getClinicas(),
					dentistaService.findAllDentistasByClinicas(usuario.getClinicas())), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ExceptionResponse>(
					new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
		}
	}
}
