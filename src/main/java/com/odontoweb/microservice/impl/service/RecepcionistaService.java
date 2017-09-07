package com.odontoweb.microservice.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.odontoweb.microservice.impl.model.Recepcionista;
import com.odontoweb.microservice.impl.repository.ClinicaRepository;
import com.odontoweb.microservice.impl.repository.RecepcionistaRepository;
import com.odontoweb.microservice.impl.repository.UsuarioRepository;

public class RecepcionistaService {

	private RecepcionistaRepository recepcionistaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ClinicaRepository clinicaRepository;

	@Autowired
	public RecepcionistaService(RecepcionistaRepository recepcionistaRepository, ClinicaRepository clinicaRepository) {
		this.recepcionistaRepository = recepcionistaRepository;
	}

	public boolean save(Recepcionista recepcionista) {
		return recepcionistaRepository.save(recepcionista) != null;
	}

	public void delete(Long id) {
		recepcionistaRepository.delete(id);
	}

	public List<Recepcionista> findAllRecepcionistasByClinica(Long cnpj) {
		return recepcionistaRepository.findAllRecepcionistasByClinica(clinicaRepository.findByCnpj(cnpj));
	}
	
	public List<Recepcionista> findAllRecepcionistasByClinicaClinicas(Long cnpj) {
		return recepcionistaRepository.findAllRecepcionistasByClinica(clinicaRepository.findByCnpj(cnpj));
	}

	public Recepcionista findById(Long idRecepcionista) {
		return recepcionistaRepository.findOne(idRecepcionista);
	}

	public Recepcionista findByUsuarioClinica(String email) {
		return recepcionistaRepository.findByUsuario(usuarioRepository.findByEmail(email));
	}

}
