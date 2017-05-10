package com.odontoweb.microservice.rest.binder;

import java.util.List;
import java.util.stream.Collectors;

import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.rest.domain.response.ClinicaResponse;

public class ClinicaBinder {

	public ClinicaResponse bindToResponse(Clinica clinica){
		return new ClinicaResponse(clinica.getId(), clinica.getNome(), clinica.getCnpj());
	}
	
	public List<ClinicaResponse> bindToResponse(List<Clinica> clinicas){
		return clinicas.stream().map(clinica -> bindToResponse(clinica)).collect(Collectors.toList());
	}
}
