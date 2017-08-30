package com.odontoweb.microservice.impl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.odontoweb.microservice.impl.model.Dentista;
import com.odontoweb.microservice.impl.repository.DentistaRepository;

public class DentistaService {

	private DentistaRepository dentistaRepository;

	@Autowired
	public DentistaService(DentistaRepository profissionalRespository) {
		this.dentistaRepository = profissionalRespository;
	}

	public boolean save(Dentista dentista) {
		return dentistaRepository.save(dentista) != null;
	}

	public void delete(Long id) {
		dentistaRepository.delete(id);
	}

	public List<Dentista> findAll() {
		return dentistaRepository.findAll();
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
