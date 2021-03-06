package com.odontoweb.microservice.impl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.odontoweb.microservice.impl.model.Clinica;
import com.odontoweb.microservice.impl.model.Dentista;
import com.odontoweb.microservice.impl.repository.ClinicaRepository;
import com.odontoweb.microservice.impl.repository.DentistaRepository;

public class DentistaService {

	@Autowired
	private DentistaRepository dentistaRepository;

	@Autowired
	private ClinicaRepository clinicaRepository;

	public DentistaService(DentistaRepository dentistaRepository, ClinicaRepository clinicaRepository) {
		this.dentistaRepository = dentistaRepository;
		this.clinicaRepository = clinicaRepository;
	}

	public boolean save(Dentista dentista) {
		return dentistaRepository.save(dentista) != null;
	}

	public void delete(Long id) {
		dentistaRepository.deleteById(id);
	}

	public List<Dentista> findAllDentistasByClinica(Long cnpj) {
		return dentistaRepository.findAllDentistasByClinica(clinicaRepository.findByCnpj(cnpj));
	}

	public List<Dentista> findAllDentistasByClinicas(List<Clinica> clinicas) {
		return dentistaRepository.findAllDentistasByClinicas(clinicas);
	}

	public Dentista findById(Long idPaciente) {
		return dentistaRepository.getOne(idPaciente);
	}

	public List<Dentista> getListDentistas(List<Long> ids) {
		List<Dentista> dentistas = new ArrayList<Dentista>();
		for (Long id : ids) {
			dentistas.add(findById(id));
		}
		return dentistas;
	}
	
	public Dentista loadClinicas(Dentista dentista, List<Long> idsClinicas){
		dentista.getUsuario().setClinicas(clinicaRepository.findClinicasByIds(idsClinicas));
		return dentista;
	}

}
