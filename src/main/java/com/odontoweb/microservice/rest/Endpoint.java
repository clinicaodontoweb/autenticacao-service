package com.odontoweb.microservice.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.odontoweb.arquitetura.model.User;
import com.odontoweb.arquitetura.security.JWTAuthorizationUtil;
import com.odontoweb.microservice.impl.model.Usuario;
import com.odontoweb.microservice.impl.service.RoleService;
import com.odontoweb.microservice.impl.service.UsuarioService;
import com.odontoweb.microservice.rest.binder.UsuarioBinder;
import com.odontoweb.microservice.rest.domain.request.UsuarioRequest;
import com.odontoweb.microservice.rest.domain.response.TokenResponse;

@RestController
public class Endpoint {
	
	@Autowired UsuarioService usuarioService;
	@Autowired RoleService roleService;
	@Autowired UsuarioBinder usuarioBinder;
	@Autowired JWTAuthorizationUtil jwtUtil;

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<TokenResponse> authenticate(@RequestBody @Valid UsuarioRequest usuarioRequest){
		Usuario usuario = usuarioService.login(usuarioRequest);
		User user = usuarioBinder.bindUser(usuario);
		
		return new ResponseEntity<TokenResponse>(new TokenResponse(jwtUtil.build(user)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public ResponseEntity<List<String>> me(Authentication authentication){
		User user = (User)authentication.getPrincipal();
		
		return new ResponseEntity<List<String>>(user.getRoles(), HttpStatus.OK);
	}
	
}
