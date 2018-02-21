package com.odontoweb.microservice.rest.binder;

import java.util.List;
import java.util.stream.Collectors;

import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.rest.domain.request.ClinicaRequest;
import com.odontoweb.microservice.rest.domain.response.ClinicaResponse;

public class ClinicaBinder {

	public ClinicaResponse modelToResponse(Clinica clinica) {
		return new ClinicaResponse(clinica.getId(), clinica.getNome(), clinica.getCnpj());
	}

	public Clinica requestToModel(ClinicaRequest clinicaRequest) {
		return new Clinica(clinicaRequest.getId(), clinicaRequest.getNome(), clinicaRequest.getCnpj(),
				clinicaRequest.getAtivo());
	}

	public List<ClinicaResponse> modelToListResponse(List<Clinica> clinicas) {
		if (clinicas == null)
			return null;
		return clinicas.stream().map(clinica -> modelToResponse(clinica)).collect(Collectors.toList());
	}

	public List<Clinica> requestToListModel(List<ClinicaRequest> clinicasRequest) {
		if (clinicasRequest == null)
			return null;
		return clinicasRequest.stream().map(clinicaRequest -> requestToModel(clinicaRequest))
				.collect(Collectors.toList());
	}
}
