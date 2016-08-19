package com.odontoweb.microservice.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.odontoweb.arquitetura.model.User;
import com.odontoweb.arquitetura.security.JWTAuthorizationUtil;
import com.odontoweb.microservice.impl.model.Teste;
import com.odontoweb.microservice.impl.model.Usuario;
import com.odontoweb.microservice.impl.service.TesteService;
import com.odontoweb.microservice.impl.service.UsuarioService;
import com.odontoweb.microservice.rest.domain.request.UsuarioRequest;
import com.odontoweb.microservice.rest.domain.response.TokenResponse;

@RestController
public class Endpoint {
	
	@Autowired UsuarioService service;
	@Autowired TesteService testeService;
	
	@Autowired JWTAuthorizationUtil jwtUtil;

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<TokenResponse> authenticate(@RequestBody @Valid UsuarioRequest usuarioRequest){
		Usuario usuario = service.login(usuarioRequest);
		User user = service.UsuarioToUserToken(usuario);
		
		return new ResponseEntity<TokenResponse>(new TokenResponse(jwtUtil.build(user)), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/protected", method = RequestMethod.GET)
	public ResponseEntity<List<Teste>> protegido(){
		return new ResponseEntity<List<Teste>>(testeService.findAll(), HttpStatus.OK);
	}
}
