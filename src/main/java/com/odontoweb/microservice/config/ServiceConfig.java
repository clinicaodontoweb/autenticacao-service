package com.odontoweb.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.odontoweb.microservice.impl.repository.ClinicaRepository;
import com.odontoweb.microservice.impl.repository.DentistaRepository;
import com.odontoweb.microservice.impl.repository.RecepcionistaRepository;
import com.odontoweb.microservice.impl.repository.RoleRepository;
import com.odontoweb.microservice.impl.repository.UsuarioRepository;
import com.odontoweb.microservice.impl.service.ClinicaService;
import com.odontoweb.microservice.impl.service.DentistaService;
import com.odontoweb.microservice.impl.service.RecepcionistaService;
import com.odontoweb.microservice.impl.service.RoleService;
import com.odontoweb.microservice.impl.service.UsuarioService;
import com.odontoweb.microservice.rest.binder.ClinicaBinder;
import com.odontoweb.microservice.rest.binder.DentistaBinder;
import com.odontoweb.microservice.rest.binder.RecepcionistaBinder;
import com.odontoweb.microservice.rest.binder.RoleBinder;
import com.odontoweb.microservice.rest.binder.UsuarioBinder;

@Configuration
public class ServiceConfig {

	@Bean
	public UsuarioService usuarioService(UsuarioRepository repositorio, Md5PasswordEncoder encoder) {
		return new UsuarioService(repositorio, encoder);
	}

	@Bean
	public RoleService roleService(RoleRepository repository) {
		return new RoleService(repository);
	}

	@Bean
	public ClinicaService clinicaService(ClinicaRepository repository) {
		return new ClinicaService(repository);
	}

	@Bean
	public DentistaService dentistaService(DentistaRepository dentistaRepository, ClinicaRepository clinicaRepository) {
		return new DentistaService(dentistaRepository, clinicaRepository);
	}

	@Bean
	public RecepcionistaService recepcionistaService(RecepcionistaRepository recepcionistaRepository,
			ClinicaRepository clinicaRepository) {
		return new RecepcionistaService(recepcionistaRepository, clinicaRepository);
	}

	@Bean
	public DentistaBinder dentistaBinder() {
		return new DentistaBinder();
	}

	@Bean
	public RecepcionistaBinder recepcionistaBinder() {
		return new RecepcionistaBinder();
	}

	@Bean
	public ClinicaBinder clinicaBinder() {
		return new ClinicaBinder();
	}

	@Bean
	public RoleBinder roleBinder() {
		return new RoleBinder();
	}

	@Bean
	public UsuarioBinder usuarioBinder(ClinicaBinder clinicaBinder, RoleBinder roleBinder) {
		return new UsuarioBinder();
	}
}
