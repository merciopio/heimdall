package com.br.mercorp.heimdall.service;

import java.util.List;
import java.util.Optional;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Role;
import com.br.mercorp.entity.User;

public interface ApplicationService{
    
	Optional<Application> findByName(String name);
	
	Optional<Application> findByAcronym(String acronym);

	Optional<Application> save(Application application);
	
	void delete(long id);
	
	Optional<Application> findOne(long id);

	List<Application> findAll();
	
}
