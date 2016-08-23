package com.odontoweb.microservice.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odontoweb.microservice.impl.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
