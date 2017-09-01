package com.odontoweb.microservice.rest.domain.response;

import java.io.Serializable;
import java.util.List;

public class ClinicasDentistasResponse implements Serializable {

	private static final long serialVersionUID = -3345986639175676112L;

	private List<ClinicaResponse> clinicas;
	private List<DentistaResponse> dentistas;

	public ClinicasDentistasResponse(List<ClinicaResponse> clinicas, List<DentistaResponse> dentistas) {
		this.clinicas = clinicas;
		this.dentistas = dentistas;
	}

	public List<ClinicaResponse> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<ClinicaResponse> clinicas) {
		this.clinicas = clinicas;
	}

	public List<DentistaResponse> getDentistas() {
		return dentistas;
	}

	public void setDentistas(List<DentistaResponse> dentistas) {
		this.dentistas = dentistas;
	}

}
