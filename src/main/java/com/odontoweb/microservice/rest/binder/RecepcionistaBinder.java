package com.odontoweb.microservice.rest.binder;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.odontoweb.microservice.impl.model.Recepcionista;
import com.odontoweb.microservice.impl.model.enums.Genero;
import com.odontoweb.microservice.impl.model.enums.TipoProfissional;
import com.odontoweb.microservice.impl.service.DentistaService;
import com.odontoweb.microservice.rest.domain.request.RecepcionistaRequest;
import com.odontoweb.microservice.rest.domain.response.RecepcionistaResponse;

public class RecepcionistaBinder implements Serializable {

	private static final long serialVersionUID = -2268580869115475558L;

	private UsuarioBinder usuarioBinder;
	private DentistaBinder dentistaBinder;
	private DentistaService dentistaService;

	public RecepcionistaBinder(UsuarioBinder usuarioBinder, DentistaBinder dentistaBinder, DentistaService dentistaService) {
		this.usuarioBinder = usuarioBinder;
		this.dentistaBinder = dentistaBinder;
		this.dentistaService = dentistaService;
	}

	public Recepcionista requestToModel(RecepcionistaRequest recepcionistaRequest) {
		if (recepcionistaRequest == null)
			return null;
		return new Recepcionista(recepcionistaRequest.getIdRecepcionista(),
				usuarioBinder.requestToModel(recepcionistaRequest.getUsuarioRequest(), TipoProfissional.RECEPCIONISTA), recepcionistaRequest.getNome(),
				Genero.valueOf(recepcionistaRequest.getGenero().toUpperCase()), dentistaService.getListDentistas(recepcionistaRequest.getDentistas()));
	}

	public RecepcionistaResponse modelToResponse(Recepcionista recepcionista) {
		if (recepcionista == null)
			return null;
		return new RecepcionistaResponse(recepcionista.getIdRecepcionista(),
				usuarioBinder.modelToResponse(recepcionista.getUsuario()), recepcionista.getNome(),
				recepcionista.getGenero().name(), dentistaBinder.modelToListResponse(recepcionista.getDentistas()));
	}

	public List<RecepcionistaResponse> modelToListResponse(List<Recepcionista> recepcionistas) {
		if (recepcionistas == null)
			return null;
		return recepcionistas.stream().filter(Objects::nonNull).map(recepcionista -> modelToResponse(recepcionista))
				.collect(Collectors.toList());

	}

}
