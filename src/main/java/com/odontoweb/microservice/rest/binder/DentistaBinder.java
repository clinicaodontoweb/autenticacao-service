package com.odontoweb.microservice.rest.binder;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.impl.model.Dentista;
import com.odontoweb.microservice.impl.model.enums.Genero;
import com.odontoweb.microservice.impl.model.enums.TipoProfissional;
import com.odontoweb.microservice.rest.domain.request.DentistaRequest;
import com.odontoweb.microservice.rest.domain.response.ClinicasDentistasResponse;
import com.odontoweb.microservice.rest.domain.response.DentistaResponse;

public class DentistaBinder implements Serializable {

	private static final long serialVersionUID = -2268580869115475558L;

	public Dentista requestToModel(DentistaRequest dentistaRequest) {
		return new Dentista(dentistaRequest.getIdDentista(), dentistaRequest.getNome(),
				Genero.valueOf(dentistaRequest.getGenero().toUpperCase()), dentistaRequest.getConselho(),
				dentistaRequest.getRegistro(), dentistaRequest.getCodigoBrasileiroOcupacao(),
				new UsuarioBinder().requestToModel(dentistaRequest.getUsuarioRequest(),TipoProfissional.DENTISTA));
	}

	public DentistaResponse modelToResponse(Dentista dentista) {
		return new DentistaResponse(dentista.getIdDentista(),
				new UsuarioBinder().modelToResponse(dentista.getUsuario()), dentista.getNome(),
				dentista.getGenero().name(), dentista.getConselho(), dentista.getRegistro(),
				dentista.getCodigoBrasileiroOcupacao());
	}

	public List<DentistaResponse> modelToListResponse(List<Dentista> dentistas) {
		if (dentistas == null)
			return null;
		return dentistas.stream().filter(Objects::nonNull).map(dentista -> modelToResponse(dentista))
				.collect(Collectors.toList());

	}

	public List<Dentista> requestToListModel(List<DentistaRequest> dentistasRequest) {
		if (dentistasRequest == null)
			return null;
		return dentistasRequest.stream().filter(Objects::nonNull)
				.map(dentistaRequest -> requestToModel(dentistaRequest)).collect(Collectors.toList());

	}

	public ClinicasDentistasResponse modelToResponse(List<Clinica> clinicas, List<Dentista> dentistas) {
		if (clinicas == null || dentistas == null)
			return null;
		return new ClinicasDentistasResponse(new ClinicaBinder().bindToResponse(clinicas),
				modelToListResponse(dentistas));
	}
}
