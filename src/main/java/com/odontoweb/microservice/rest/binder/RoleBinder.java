package com.odontoweb.microservice.rest.binder;

import java.util.List;
import java.util.stream.Collectors;

import com.odontoweb.microservice.impl.model.Role;
import com.odontoweb.microservice.rest.domain.response.RoleResponse;

public class RoleBinder {

	public RoleResponse bindToResponse(Role role){
		return new RoleResponse(role.getId(), role.getRole());
	}
	
	public List<RoleResponse> bindToResponse(List<Role> roles){
		return roles.stream().map(role -> bindToResponse(role)).collect(Collectors.toList());
	}
}
