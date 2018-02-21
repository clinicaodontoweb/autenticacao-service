package com.odontoweb.microservice.rest.domain.request;

import java.io.Serializable;

public class RoleRequest implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String role;
	
	public RoleRequest() {}

	public RoleRequest(Long id, String role) {
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
