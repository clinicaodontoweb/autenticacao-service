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

	
	public DentistaService(DentistaRepository profissionalRespository, ClinicaRepository clinicaRespository) {
		this.dentistaRepository = profissionalRespository;
		this.clinicaRepository = clinicaRespository;
	}

	public boolean save(Dentista dentista) {
		return dentistaRepository.save(dentista) != null;
	}

	public void delete(Long id) {
		dentistaRepository.delete(id);
	}

	public List<Dentista> findAllDentistasByClinica(Long idClinica) {
		Clinica clinica = clinicaRepository.findOne(idClinica);		
		List<Dentista> dentistas = dentistaRepository.findAllDentistasByClinica(clinica);
		return dentistas; 
	}

	public Dentista findById(Long idPaciente) {
		return dentistaRepository.findOne(idPaciente);
	}
	
	public List<Dentista> getListDentistas(List<Long> ids){
		List<Dentista> dentistas = new ArrayList<Dentista>();
		for (Long id : ids) {
			dentistas.add(findById(id));
		}
		return dentistas;
	}

}
