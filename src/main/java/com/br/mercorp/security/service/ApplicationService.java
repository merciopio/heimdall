package com.br.mercorp.security.service;

import java.util.Optional;

import com.br.mercorp.entity.Application;

public interface ApplicationService{
    
	Optional<Application> findByName(String name);

	Optional<Application> findByAcronym(String acronym);
	
	
}
