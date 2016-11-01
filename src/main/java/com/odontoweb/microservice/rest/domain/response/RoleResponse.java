package com.odontoweb.microservice.rest.domain.response;

import java.io.Serializable;

public class RoleResponse implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String role;
	
	public RoleResponse() {}

	public RoleResponse(Long id, String role) {
		this.id = id;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
