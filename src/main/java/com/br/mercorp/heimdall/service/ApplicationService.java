package com.br.mercorp.heimdall.service;

import java.util.List;
import java.util.Optional;

import com.br.mercorp.entity.Application;

public interface ApplicationService extends com.br.mercorp.security.service.BaseApplicationService{
    
	Optional<Application> save(Application application);
	
	void delete(long id);
	
	Optional<Application> findOne(long id);

	List<Application> findAll();
	
}
